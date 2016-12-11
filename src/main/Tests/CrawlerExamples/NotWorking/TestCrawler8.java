/*
package main.Tests.CrawlerExamples;

import main.Tests.WebCrawler;

import javax.lang.model.util.Elements;
import javax.swing.text.Document;
import javax.swing.text.Element;
import java.beans.Statement;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

*/
/**
 * Created by Ats on 8.12.2016.
 *//*

public class TestCrawler8 {

    public static void main(String[] args) throws Exception {
        //init DB interaction
        try {
            dbClass = new MainDBClass();
        } catch (Exception ex) {
            Logger.getLogger(WebCrawler.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Init menu  choice and execution
        executionOfMenuChoice();
    }

    public static void executionOfMenuChoice() throws Exception {
        while (true) {
            menuView();
            Scanner in = new Scanner(System.in);
            String input = in.next();
            switch (input) {
                case "1":
                    //process through all of the links on a page and continue
                    String[] nextEntryForProcessing;
                    while (true) {
                        nextEntryForProcessing = dbClass.getNextEntryForProcessing();
                        urlParsing(nextEntryForProcessing[0]); //0 is url and 1 is title
                        dbClass.moveEntryAfterParsing(nextEntryForProcessing[0], nextEntryForProcessing[1]);
                    }
                case "2":
                    //use this method to get all the results plus number of rows on the end for each table
                    dbClass.getAllEntriesCollected();
                    break;
                case "3":
                    dbClass.getAllEntriesCollectedCount();
                    break;
                case "4":
                    //Use truncate if you wish to delete your tables
                    dbClass.truncateTables();
                    break;
                case "5":
                    //Exiting an application
                    System.exit(0);
            }
        }
    }

    public static void menuView() throws Exception {
        System.out.println("############################");
        System.out.println("1.) Press 1 to start/continue parsing and collecting links and titles");
        System.out.println("2.) Press 2 to print all collected and parsed links");
        System.out.println("3.) Press 3 to print number of processed and collected links");
        System.out.println("4.) Press 4 to truncate all data in the tables");
        System.out.println("4.) Press 5 to exit");
        System.out.println("############################");
    }

    public MainDBClass() throws Exception {
        Class.forName("org.sqlite.JDBC");
        this.conn = DriverManager.getConnection("jdbc:sqlite:linkdatabase.db");
        createTables();
    }

    public void createTables() throws Exception{
        Statement stat = conn.createStatement();

        stat.executeUpdate("CREATE TABLE IF NOT EXISTS collected_links (url TEXT UNIQUE, title);");
        stat.executeUpdate("CREATE TABLE IF NOT EXISTS processed_links (url TEXT UNIQUE, title);");
        stat.executeUpdate("INSERT OR IGNORE INTO collected_links VALUES('http://codeandunicorns.com', 'Dummy link');");
    }

    nextEntryForProcessing = dbClass.getNextEntryForProcessing();
    urlParsing(nextEntryForProcessing[0]); //0 is url and 1 is title
    dbClass.moveEntryAfterParsing(nextEntryForProcessing[0], nextEntryForProcessing[1]);

    public static void processPage(String URL) throws Exception {
        //get useful information
        boolean skip = false;
        Document doc = null;
        try {
            doc = Jsoup.connect(URL).timeout(5 * 1000).ignoreContentType(true).get();
        } catch (IOException ex) {
            Logger.getLogger(WebCrawler.class.getName()).log(Level.SEVERE, null, ex);
            dbClass.moveEntryAfterParsing(URL, URL);
            skip = true;
        }

        //get all links and recursively call the processPage method
        if (!skip) {
            Elements questions = doc.select("a[href]");
            for (Element link : questions) {

                //inserts every new url into DB
                if (link.attr("abs:href").startsWith("http")) {
                    System.out.println(link.attr("abs:href"));
                 */
/*Document titleDoc = Jsoup.connect(URL).get();
                  String title = doc.title();*//*

                    if (!link.attr("abs:href").contains(" ")) {
                        dbClass.insertNewEntry(link.attr("abs:href"), link.attr("abs:href"));
                    }
                }
            }
        }
    }

}
*/
