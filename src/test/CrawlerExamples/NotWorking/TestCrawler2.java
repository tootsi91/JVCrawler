package main.Tests.CrawlerExamples.NotWorking;

public class TestCrawler2 {


    /*public static void main(String[] args) throws IOException, SQLException {

        File dir = new File("C:\\Users\\Ats\\KOOL\\Programmeerimise Alused\\Iseseisev töö");
        String loc = dir.getCanonicalPath() + File.separator + "record.txt";
        FileWriter fstream = new FileWriter(loc, true);
        BufferedWriter out = new BufferedWriter(fstream);
        out.newLine();
        out.close();

        processPage("http://www.neti.ee");

        File file = new File(loc);

        if (file.delete()) {

        }
    }

    public static void processPage(String URL) throws SQLException, IOException{
        //check if the given URL is already in database
        String sql = "select * from Record where URL = '"+URL+"'";
        ResultSet rs = db.runSql(sql);
        if(rs.next()){

        }else{
            //store the URL to database to avoid parsing again
            sql = "INSERT INTO  `Crawler`.`Record` " + "(`URL`) VALUES " + "(?);";
            PreparedStatement stmt = db.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, URL);
            stmt.execute();

            //get useful information
            Document doc = Jsoup.connect("http://www.mit.edu/").get();

            if(doc.text().contains("research")){
                System.out.println(URL);
            }

            //get all links and recursively call the processPage method
            Elements questions = doc.select("a[href]");
            for(Element link: questions){
                if(link.attr("href").contains("mit.edu"))
                    processPage(link.attr("abs:href"));
            }
        }
    }*/
}