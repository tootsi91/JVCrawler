import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Crawler {

    public void doSearch(String url) throws Exception {
        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("a[href]");
        List<String> list = new ArrayList<String>();

        for (Element link : links) {
            String text = link.attr("abs:href");
            System.out.println(text);
            list.add(text);
        }
        /*
        String urls[] = new String[1000];




        int i=0,j=0,tmp=0,total=0, MAX = 1000;
        int start=0, end=0;
        String webpage = Web.getWeb(url);
        end = webpage.indexOf("<body");
        for(i=total;i<MAX; i++, total++){
            start = webpage.indexOf("http://", end);
            if(start == -1){
                start = 0;
                end = 0;
                try{
                    webpage = Web.getWeb(urls[j++]);
                }catch(Exception e){
                    System.out.println("******************");
                    System.out.println(urls[j-1]);
                    System.out.println("Exception caught \n"+e);
                }

                //logic to fetch urls out of body of webpage only
                end = webpage.indexOf("<body");
                if(end == -1){
                    end = start = 0;
                    continue;
                }
            }
            end = webpage.indexOf("\"", start);
            tmp = webpage.indexOf("'", start);
            if(tmp < end && tmp != -1){
                end = tmp;
            }
            url = webpage.substring(start, end);
            urls[i] = url;
            System.out.println(urls[i]);
        }
        */
        System.out.println("Total URLS Fetched are " + list.size());
    }

    private String loadHtmlFromUrl(String url) {
        Document doc = null;
        try {
            doc = Jsoup.connect("http://example.com/").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc.outerHtml();
    }

    public static void main(String[] args) throws Exception{
        new Crawler().doSearch("http://www.neti.ee");
    }
}

