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
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;


public class Main extends Application {

    public static void main(String[] args) throws Exception {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Java Web Crawler");
        TextArea ta = TextAreaBuilder.create().prefWidth(800).prefHeight(600).wrapText(true).build();
        Console console = new Console(ta);
        PrintStream ps = new PrintStream(console, true);
        System.setOut(ps);
        System.setErr(ps);
        Scene app = new Scene(ta);

        primaryStage.setScene(app);
        primaryStage.show();

        for (char c : "some text".toCharArray()) {
            console.write(c);
        }
        ps.close();

        init(primaryStage);
        primaryStage.show();
    }

    //Public void Crawler

    public static class Console extends OutputStream {

        private TextArea output;

        public Console(TextArea ta) {
            this.output = ta;
        }

        @Override
        public void write(int i) throws IOException {
            output.appendText(String.valueOf((char) i));
        }
    }

    //GUI
    public void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setScene(new Scene(root, 350, 600));
        String validatorCss = Main.class.getResource("Validators.css").toExternalForm();

        VBox vbox = new VBox();
        TabPane tp = new TabPane();
        tp.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Tab app_tab = new Tab("App");
        HBox hb = new HBox();

        app_tab.setContent(hb);

        Tab info_tab = new Tab("Info");

        Label Info = new Label("Ats Toots, C11");
        GridPane.setConstraints(Info, 2, 0);
        GridPane.setHalignment(Info, HPos.RIGHT);

        info_tab.setContent(Info);


        tp.getTabs().addAll(app_tab, info_tab);
        vbox.getChildren().addAll(tp);

        //Text Box
        Label grid2Caption = new Label("Insert the name of the webpage you want to search below:");
        grid2Caption.setWrapText(true);
        final TextField textBox = new TextField();
        TextInputValidatorPane <TextField> pane = new TextInputValidatorPane <TextField>();
        pane.setContent(textBox);
        pane.setValidator(new Validator <TextField>() {
            public ValidationResult validate(TextField control) {
                try {
                    String text = control.getText();
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
                String urls[] = new String[1000];
                String url = textBox.getText();
                int i=0,j=0,tmp=0,total=0, MAX = 1000;
                int start=0, end=0;
                String webpage = null;
                try {
                    webpage = Web.getWeb(url);
                } catch (Exception e) {
                    e.printStackTrace();
                }
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
                }
            }});

        vbox.setPadding(new Insets(12));
        vbox.getChildren().addAll(grid2Caption, pane, button);

        Label grid3Caption = new Label("Search results");
        grid3Caption.setWrapText(true);
        ListView <String> listView = new ListView <String>();
        listView.setItems(FXCollections.<String>observableArrayList());
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


        vbox.getChildren().addAll(grid3Caption, listView);

        pane.getStylesheets().add(validatorCss);
        root.getChildren().add(vbox);

    }

    public static class ValidationResult {
        public enum Type {ERROR, WARNING, SUCCESS}

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
        public static final EventType <ValidationEvent> ANY =
                new EventType <ValidationEvent>(Event.ANY, "VALIDATION");

        private final ValidationResult result;

        public ValidationEvent(ValidationResult result) {
            super(ANY);
            this.result = result;
        }

        public final ValidationResult getResult() {
            return result;
        }
    }

    private abstract class ValidatorPane<C extends Control> extends Region {
        /**
         * The content for the validator pane is the control it should work with.
         */
        private ObjectProperty <C> content = new SimpleObjectProperty <C>(this, "content", null);

        public final C getContent() {
            return content.get();
        }

        public final void setContent(C value) {
            content.set(value);
        }

        public final ObjectProperty <C> contentProperty() {
            return content;
        }

        /**
         * The validator
         */
        private ObjectProperty <Validator <C>> validator = new SimpleObjectProperty <Validator <C>>(this, "validator");

        public final Validator <C> getValidator() {
            return validator.get();
        }

        public final void setValidator(Validator <C> value) {
            validator.set(value);
        }

        public final ObjectProperty <Validator <C>> validatorProperty() {
            return validator;
        }

        /**
         * The validation result
         */
        private ReadOnlyObjectWrapper <ValidationResult> validationResult = new ReadOnlyObjectWrapper <ValidationResult>(this, "validationResult");

        public final ValidationResult getValidationResult() {
            return validationResult.get();
        }

        public final ReadOnlyObjectProperty <ValidationResult> validationResultProperty() {
            return validationResult.getReadOnlyProperty();
        }

        /**
         * The event handler
         */
        private ObjectProperty <EventHandler <ValidationEvent>> onValidation =
                new SimpleObjectProperty <EventHandler <ValidationEvent>>(this, "onValidation");

        public final EventHandler <ValidationEvent> getOnValidation() {
            return onValidation.get();
        }

        public final void setOnValidation(EventHandler <ValidationEvent> value) {
            onValidation.set(value);
        }

        public final ObjectProperty <EventHandler <ValidationEvent>> onValidationProperty() {
            return onValidation;
        }

        public ValidatorPane() {
            content.addListener(new ChangeListener <Control>() {
                public void changed(ObservableValue <? extends Control> ov, Control oldValue, Control newValue) {
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

    private class TextInputValidatorPane<C extends TextInputControl> extends ValidatorPane <C> {

        private InvalidationListener textListener = new InvalidationListener() {
            @Override
            public void invalidated(Observable o) {
                final Validator v = getValidator();
                final ValidationResult result = v != null ?
                        v.validate(getContent()) :
                        new ValidationResult("", ValidationResult.Type.SUCCESS);

                handleValidationResult(result);
            }
        };

        public TextInputValidatorPane() {
            contentProperty().addListener(new ChangeListener <C>() {
                @Override
                public void changed(ObservableValue <? extends C> ov, C oldValue, C newValue) {
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
}