package main.Tests.CrawlerExamples.NotWorking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestCrawler7 {

    static public void main(String[] args) {

        TestCrawler7 c = new TestCrawler7();
        c.Crawl("http://www.neti.ee");
    }

    public void Crawl(String startUrl) {

        // Set up crawl lists.
        HashSet crawledList = new HashSet();
        LinkedHashSet toCrawlList = new LinkedHashSet();
        // Add start URL to the To Crawl list.
        toCrawlList.add(startUrl);

        // Get URL at bottom of the list.
        String url = (String) toCrawlList.iterator().next();
        // Remove URL from the To Crawl list.
        toCrawlList.remove(url);
        // Convert string url to URL object.
        URL verifiedUrl = verifyUrl(url);

        // Add page to the crawled list.
        crawledList.add(url);
        // Download the page at the given URL.
        String pageContents = downloadPage(verifiedUrl);

        if (pageContents != null && pageContents.length() > 0) {
            // Retrieve list of valid links from page.
            ArrayList links = retrieveLinks(verifiedUrl, pageContents, crawledList);
            // Add links to the To Crawl list.
            toCrawlList.addAll(links);

        }

        System.out.println(pageContents);

    }

    private String downloadPage(URL pageUrl) {

        try {
            // Open connection to URL for reading.
            BufferedReader reader = new BufferedReader(new InputStreamReader(pageUrl.openStream()));
            // Read page into buffer.
            String line;
            StringBuffer pageBuffer = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                pageBuffer.append(line);
            }
            return pageBuffer.toString();
        } catch (Exception e) {
        }
        return null;
    }

    private URL verifyUrl(String url) {
        if (!url.toLowerCase().startsWith("http://")) {
            return null;
        }
        URL verifiedUrl = null;
        try {
            verifiedUrl = new URL(url);
        } catch (Exception e) {
            return null;
        }
        return verifiedUrl;
    }

    private ArrayList retrieveLinks(URL pageUrl, String pageContents, HashSet crawledList) {
        Pattern p = Pattern.compile("<a\\s+href\\s*=\\s*\"?(.*?)[\"|>]", Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(pageContents);
            // Create list of link matches.
            ArrayList linkList = new ArrayList();
            while (m.find()) {
                String link = m.group(1).trim();
                // Skip empty links.
                if (link.length() < 1) {
                    continue;
                }
                // Skip links that are just page anchors.
                if (link.charAt(0) == '#') {
                    continue;
                }
                // Skip mailto links.
                if (link.indexOf("mailto:") != -1) {
                    continue;
                }
                // Skip Javascript links.
                if (link.toLowerCase().indexOf("javascript") != -1) {
                    continue;
                }
                // Prefix absolute and relative URLs if necessary.
                if (link.indexOf("://") == -1) {
                    // Handle absolute URLs.
                    if (link.charAt(0) == '/') {
                        link = "http://" + pageUrl.getHost() + link;
                        // Handle relative URLs.
                    }
                    else {
                        String file = pageUrl.getFile();
                        if (file.indexOf('/') == -1) {
                            link = "http://" + pageUrl.getHost() + "/" + link;

                        }
                        else {
                            String path = file.substring(0, file.lastIndexOf('/') + 1);
                            link = "http://" + pageUrl.getHost() + path + link;
                        }
                    }
                }

                // Remove anchors from link.
                int index = link.indexOf('#');
                if (index != -1) {
                    link = link.substring(0, index);
                }
                // Remove leading "www" from URL's host if present.
                link = removeWwwFromUrl(link);
                // Verify link and skip if invalid.
                URL verifiedLink = verifyUrl(link);
                if (verifiedLink == null) {
                    continue;
                }
                // Skip link if it has already been crawled.
                if (crawledList.contains(link)) {
                    continue;
                }
                // Add link to list.
                linkList.add(link);
            }
            return (linkList);
    }

    private String removeWwwFromUrl(String url) {
        int index = url.indexOf("://www.");
        if (index != -1) {
            return url.substring(0, index + 3) + url.substring(index + 7);
        }
        return (url);
    }
}
