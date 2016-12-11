/*
package main.Tests.CrawlerExamples.Working.Crawler;

public class TestCrawler6{

    public static void main(String[] args) throws Exception{

        String urls[] = new String[1000];
        String url = "http://www.nandal.in";
        int i=0,j=0,tmp=0,total=0, MAX = 1000;
        int start=0, end=0;
        String webpage = Web2.getWeb(url);
        end = webpage.indexOf("<body");
        for(i=total;i<MAX; i++, total++){
            start = webpage.indexOf("http://", end);
            if(start == -1){
                start = 0;
                end = 0;
                try{
                    webpage = Web2.getWeb(urls[j++]);
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
        System.out.println("Total URLS Fetched are " + total);
    }
}

*/
