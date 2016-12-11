/*
package main.Tests.VARU;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.net.URL;

public class JavaFXMain extends Application {

    private boolean crawling;
    @FXML
    private TextField startTextField;
    private ComboBox<String> maxComboBox;


    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Java Web Crawler");
        Pane root = new Pane();

        init(primaryStage);
        primaryStage.show();
    }

    //GUI
    private void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setScene(new Scene(root, 500, 500));

        VBox vbox = new VBox();

        Label grid1Caption = new Label("Info:");
        grid1Caption.setWrapText(true);
        GridPane grid1 = new GridPane();
        grid1.setHgap(6);
        grid1.setVgap(6);
        grid1.setPadding(new Insets(18, 18, 18, 18));
        ObservableList<Node> content = grid1.getChildren();

        Label label = new Label("Name:");
        GridPane.setConstraints(label, 0, 0);
        GridPane.setHalignment(label, HPos.RIGHT);
        content.add(label);

        label = new Label("Ats Tootsi");
        GridPane.setConstraints(label, 1, 0, 2, 1);
        GridPane.setHalignment(label, HPos.LEFT);
        content.add(label);

        label = new Label("Gorup:");
        GridPane.setConstraints(label, 0, 1);
        GridPane.setHalignment(label, HPos.RIGHT);
        content.add(label);

        label = new Label("C11");
        GridPane.setConstraints(label, 1, 1, 5, 1);
        GridPane.setHalignment(label, HPos.LEFT);
        content.add(label);

        vbox.getChildren().addAll(grid1Caption, grid1);

        Label grid2Caption = new Label("Insert the name of the webpage you want to search below:");
        grid2Caption.setWrapText(true);
        GridPane grid2 = new GridPane();
        grid2.setPadding(new Insets(18, 18, 18, 18));
        grid2.setGridLinesVisible(false);
        TextField textBox = new TextField("Insert link here:");
        GridPane.setMargin(textBox, new Insets(10, 10, 10, 10));
        GridPane.setConstraints(textBox, 0, 0);



        //Button
        Button button = new Button("Search");


*/
/*        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void actionSearch() {
                // If stop button clicked, turn crawling flag off.
                if (crawling) {
                    crawling = false;
                    return;
                }
                ArrayList errorList = new ArrayList();
                // Validate that start URL has been entered.
                String startUrl = startTextField.getText().trim();
                if (startUrl.length() < 1) {
                    errorList.add("Missing Start URL.");
                }
                // Verify start URL.
                else if (verifyUrl(startUrl) == null) {
                    errorList.add("Invalid Start URL.");
                }
                // Validate that Max URLs is either empty or is a number.
                int maxUrls = 0;
                String max = ((String) maxComboBox.getSelectedItem()).trim();
                if (max.length() > 0) {
                    try {
                        maxUrls = Integer.parseInt(max);
                    } catch (NumberFormatException e) {
                    }
                    if (maxUrls < 1) {
                        errorList.add("Invalid Max URLs value.");
                    }
                }
                // Validate that matches log file has been entered.
                String logFile = logTextField.getText().trim();
                if (logFile.length() < 1) {
                    errorList.add("Missing Matches Log File.");
                }
                // Validate that search string has been entered.
                String searchString = searchTextField.getText().trim();
                if (searchString.length() < 1) {
                    errorList.add("Missing Search String.");
                }
                // Show errors, if any, and return.
                if (errorList.size() > 0) {
                    StringBuffer message = new StringBuffer();
                    // Concatenate errors into single message.
                    for (int i = 0; i < errorList.size(); i++) {
                        message.append(errorList.get(i));
                        if (i + 1 < errorList.size()) {
                            message.append("\n");
                        }
                    }
                    showError(message.toString());
                    return;
                }
                // Remove "www" from start URL if present.
                startUrl = removeWwwFromUrl(startUrl);
                // Start the Search Crawler.
                search(logFile, startUrl, maxUrls, searchString);
            }
        });*//*



*/
/*        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event) {
                FileCrawler.processPage("http://www.neti.ee");
            }
        });*//*

*/
/*        button.setOnAction(new EventHandler() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //... do something in here.
            }
        });*//*




 */
/*       button.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                try {
                    processPage("www.neti.ee");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                *//*
*/
/*label.setText("Searching")*//*
*/
/*;
            }        });*//*



        vbox.getChildren().addAll(grid2Caption, grid2, textBox, button);

        Label grid3Caption = new Label ("Search results");
        grid2Caption.setWrapText(true);
        GridPane grid3 = new GridPane();
        grid3.setPadding(new Insets(18, 18, 18, 18));
        grid3.setGridLinesVisible(false);
        RowConstraints rowinfo3 = new RowConstraints();
        rowinfo3.setPercentHeight(50);
        ColumnConstraints colInfo3 = new ColumnConstraints();
        colInfo3.setPercentWidth(50);
        GridPane.setConstraints(label, 1, 1, 5, 1);
        GridPane.setHalignment(label, HPos.LEFT);
        GridPane.setConstraints(button, 1, 0);
        GridPane.setMargin(button, new Insets(10, 10, 10, 10));
        GridPane.setHalignment(button, HPos.CENTER);

        vbox.getChildren().addAll(grid3Caption, grid3);


        root.getChildren().add(vbox);

    }

    private URL verifyUrl(String url) {
        // Only allow HTTP URLs.
        if (!url.toLowerCase().startsWith("http://"))
            return null;
        // Verify format of URL.
        URL verifiedUrl = null;
        try {
            verifiedUrl = new URL(url);
        } catch (Exception e) {
            return null;
        }
        return verifiedUrl;
    }

    //Search string
*/
/*    public static boolean checkExist(String s, File fin) throws IOException {

        FileInputStream fis = new FileInputStream(fin);
        // //Construct the BufferedReader object
        BufferedReader in = new BufferedReader(new InputStreamReader(fis));

        String aLine = null;
        while ((aLine = in.readLine()) != null) {
            // //Process each line
            if (aLine.trim().contains(s)) {
                //System.out.println("contains " + s);
                in.close();
                fis.close();
                return true;
            }
        }

        in.close();
        fis.close();

        return false;
    }*//*



    // Search method

*/
/*    private void actionSearch() {


    }*//*






*/
/*    public static void processPage(String URL) throws IOException {

        File dir = new File(".");
        String loc = dir.getCanonicalPath() + File.separator + "record.txt";

        // invalid link
        if (URL.contains(".pdf") || URL.contains("@")
                || URL.contains("adfad") || URL.contains(":80")
                || URL.contains("fdafd") || URL.contains(".jpg")
                || URL.contains(".pdf") || URL.contains(".jpg"))
            return;

        // process the url first
        if (URL.contains("www.neti.ee") && !URL.endsWith("/")) {

        } else if (URL.contains("www.neti.ee") && URL.endsWith("/")) {
            URL = URL.substring(0, URL.length() - 1);
        } else {
            // url of other site -> do nothing
            return;
        }

        File file = new File(loc);

        // check existance
        boolean e = checkExist(URL, file);
        if (!e) {
            System.out.println("------ :  " + URL);
            // insert to file
            FileWriter fstream = new FileWriter(loc, true);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(URL);
            out.newLine();
            out.close();

            Document doc = null;
            try {
                doc = Jsoup.connect(URL).get();
            } catch (IOException e1) {
                e1.printStackTrace();
                return;
            }

            if (doc.text().contains("PhD")) {
                //System.out.println(URL);
            }

            Elements questions = doc.select("a[href]");
            for (Element link : questions) {
                processPage(link.attr("abs:href"));
            }
        } else {
            // do nothing
            return;
        }
    }*//*


}


*/
