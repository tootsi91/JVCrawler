/*
package main.Tests.VARU;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.Tests.FileCrawler;

import java.io.IOException;

public class MainVARU extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Java Web Crawler");
        init(primaryStage);
        primaryStage.show();
    }

    //GUI
    private void init(Stage primaryStage) {
        Group root = new Group();

        primaryStage.setScene(new Scene(root, 350, 600));
        String validatorCss = MainVARU.class.getResource("Validators.css").toExternalForm();

        VBox vbox = new VBox();

        TabPane tp = new TabPane();
        tp.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Tab app_tab = new Tab("App");
        HBox hb = new HBox();



        app_tab.setContent(hb);

        Tab help_tab = new Tab("Help");

        Label grid1Caption = new Label("Info:");
        grid1Caption.setWrapText(true);
        GridPane grid1 = new GridPane();
        grid1.setHgap(6);
        grid1.setVgap(6);
        grid1.setPadding(new Insets(18, 18, 18, 18));
        ObservableList<Node> content = grid1.getChildren();

        Label Info = new Label("Ats Toots, C11");
        GridPane.setConstraints(Info, 0, 0);
        GridPane.setHalignment(Info, HPos.RIGHT);
        content.add(Info);

*/
/*        label = new Label("Ats Tootsi");
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
        content.add(label);*//*


        help_tab.setContent(Info);

        tp.getTabs().addAll(app_tab, help_tab);

        //Tab




        */
/*
        BorderPane borderPane = new BorderPane();
        final TabPane tabPane = new TabPane();
        tabPane.setPrefSize(300, 400);
        tabPane.setSide(Side.TOP);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        final Tab tab1 = new Tab();
        tab1.setText("Crawler");
        final Tab tab2 = new Tab();
        tab2.setText("Info");
        tabPane.getTabs().addAll(tab1, tab2);
        borderPane.setCenter(tabPane);
*//*




        vbox.getChildren().addAll(*/
/*borderPane, *//*
tp, grid1Caption, grid1);

        //Text Box
        Label grid2Caption = new Label("Insert the name of the webpage you want to search below:");
        grid2Caption.setWrapText(true);
        TextField textBox = new TextField();
        TextInputValidatorPane<TextField> pane = new TextInputValidatorPane<TextField>();
        pane.setContent(textBox);
        pane.setValidator(new Validator<TextField>() {
            public ValidationResult validate(TextField control) {
                try {String text = control.getText();
                    if (text == null || text.trim().equals("")) return null;
                    else if (text.toLowerCase().startsWith("http://"))
                        return new ValidationResult("Valid Link", ValidationResult.Type.SUCCESS);
                    else if ((text.endsWith(".pdf") || text.contains("@") || text.endsWith(".jpg")))
                        return new ValidationResult("Invalid Link", ValidationResult.Type.WARNING);
                    else return null;
                } catch (Exception e) {
                    return new ValidationResult("Error", ValidationResult.Type.ERROR);
                }

            }
        });

        //Button
        Button button = new Button("Search");
        button.setPrefSize(190, 20);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    FileCrawler.processPage("http://www.neti.ee");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }});




*/
/*        buttonAddNumber.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent t) {

            }
        });*//*


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



        vbox.setPadding(new Insets(12));
        vbox.getChildren().addAll(grid2Caption, pane, button);

        Label grid3Caption = new Label ("Search results");
        grid3Caption.setWrapText(true);
        ListView<String> listView = new ListView<String>();
        listView.setItems(FXCollections.observableArrayList(
                "www.example.com", "www.example.com", "www.example.com", "www.example.com", "www.example.com",
                "www.example.com", "www.example.com", "www.example.com", "www.example.com", "www.example.com",
                "www.example.com", "www.example.com", "www.example.com", "www.example.com", "www.example.com",
                "www.example.com", "www.example.com", "www.example.com", "www.example.com", "www.example.com"
        ));

        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        vbox.getChildren().addAll(grid3Caption, listView);

        pane.getStylesheets().add(validatorCss);
        root.getChildren().add(vbox);

    }

    public static class ValidationResult {
        public enum Type { ERROR, WARNING, SUCCESS }
        private final String message;
        private final Type type;

        public ValidationResult(String message, Type type) {
            this.message = message;
            this.type = type;
        }

        public final String getMessage() {
            return message;
        }

        public final Type getType() {
            return type;
        }
    }

    private static interface Validator<C extends Control> {
        public ValidationResult validate(C control);
    }

    public static class ValidationEvent extends Event {
        public static final EventType<ValidationEvent> ANY =
                new EventType<ValidationEvent>(Event.ANY, "VALIDATION");

        private final ValidationResult result;

        public ValidationEvent(ValidationResult result) {
            super(ANY);
            this.result = result;
        }

        public final ValidationResult getResult() { return result; }
    }

    private abstract class ValidatorPane<C extends Control> extends Region {
        */
/**
         * The content for the validator pane is the control it should work with.
         *//*

        private ObjectProperty<C> content = new SimpleObjectProperty<C>(this, "content", null);
        public final C getContent() { return content.get(); }
        public final void setContent(C value) { content.set(value); }
        public final ObjectProperty<C> contentProperty() { return content; }

        */
/**
         * The validator
         *//*

        private ObjectProperty<Validator<C>> validator = new SimpleObjectProperty<Validator<C>>(this, "validator");
        public final Validator<C> getValidator() { return validator.get(); }
        public final void setValidator(Validator<C> value) { validator.set(value); }
        public final ObjectProperty<Validator<C>> validatorProperty() { return validator; }

        */
/**
         * The validation result
         *//*

        private ReadOnlyObjectWrapper<ValidationResult> validationResult = new ReadOnlyObjectWrapper<ValidationResult>(this, "validationResult");
        public final ValidationResult getValidationResult() { return validationResult.get(); }
        public final ReadOnlyObjectProperty<ValidationResult> validationResultProperty() { return validationResult.getReadOnlyProperty(); }

        */
/**
         *  The event handler
         *//*

        private ObjectProperty<EventHandler<ValidationEvent>> onValidation =
                new SimpleObjectProperty<EventHandler<ValidationEvent>>(this, "onValidation");
        public final EventHandler<ValidationEvent> getOnValidation() { return onValidation.get(); }
        public final void setOnValidation(EventHandler<ValidationEvent> value) { onValidation.set(value); }
        public final ObjectProperty<EventHandler<ValidationEvent>> onValidationProperty() { return onValidation; }

        public ValidatorPane() {
            content.addListener(new ChangeListener<Control>() {
                public void changed(ObservableValue<? extends Control> ov, Control oldValue, Control newValue) {
                    if (oldValue != null) getChildren().remove(oldValue);
                    if (newValue != null) getChildren().add(0, newValue);
                }
            });
        }

        //Adds color

        protected void handleValidationResult(ValidationResult result) {
            getStyleClass().removeAll("validation-error", "validation-warning");
            if (result != null) {
                if (result.getType() == ValidationResult.Type.ERROR) {
                    getStyleClass().add("validation-error");
                } else if (result.getType() == ValidationResult.Type.WARNING) {
                    getStyleClass().add("validation-warning");
                } else if (result.getType() == ValidationResult.Type.SUCCESS) {
                    getStyleClass().add("validation-success");
                }
            }
            validationResult.set(result);
            fireEvent(new ValidationEvent(result));
        }

        @Override
        protected void layoutChildren() {
            Control c = content.get();
            if (c != null) {
                c.resizeRelocate(0, 0, getWidth(), getHeight());
            }
        }
    }

    private class TextInputValidatorPane<C extends TextInputControl> extends ValidatorPane<C> {

        private InvalidationListener textListener = new InvalidationListener() {
            @Override public void invalidated(Observable o) {
                final Validator v = getValidator();
                final ValidationResult result = v != null ?
                        v.validate(getContent()) :
                        new ValidationResult("", ValidationResult.Type.SUCCESS);

                handleValidationResult(result);
            }
        };

        public TextInputValidatorPane() {
            contentProperty().addListener(new ChangeListener<C>() {
                @Override public void changed(ObservableValue<? extends C> ov, C oldValue, C newValue) {
                    if (oldValue != null) oldValue.textProperty().removeListener(textListener);
                    if (newValue != null) newValue.textProperty().addListener(textListener);
                }
            });
        }

        public TextInputValidatorPane(C field) {
            this();
            setContent(field);
        }

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


}*/
