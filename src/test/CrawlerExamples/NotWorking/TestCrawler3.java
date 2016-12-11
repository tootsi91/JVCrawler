package main.Tests.CrawlerExamples.NotWorking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class TestCrawler3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        try {
            URL my_url = new URL("http://www.neti.ee");
            BufferedReader br = new BufferedReader(new InputStreamReader(my_url.openStream()));
            String strTemp = "kool";
            while(null != (strTemp = br.readLine())){
                System.out.println(strTemp);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}