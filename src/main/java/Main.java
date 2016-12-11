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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.apache.commons.validator.routines.UrlValidator;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;


public class Main extends Application {

    private Crawler crawler;

    private TextField textBox;

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        crawler = new Crawler();

        primaryStage.setTitle("Java Web Crawler");

        init(primaryStage);
        primaryStage.show();
    }

    //GUI
    public void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setScene(new Scene(root, 600, 400));
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
        textBox = new TextField();

        //Button
        final Button button = new Button("Search");
        button.setDisable(true);
        button.setPrefSize(190, 20);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String url = textBox.getText();
                try {
                    crawler.doSearch(url);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }});

        textBox.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                String url = textBox.getText();
                boolean validUrl = new UrlValidator().isValid(url);

                if(validUrl) {
                    button.setDisable(false);
                }
                if (validUrl && ke.getCode().equals(KeyCode.ENTER)) {
                    button.fire();
                }
            }
        });

        vbox.setPadding(new Insets(12));
        vbox.getChildren().addAll(grid2Caption, textBox, button);

        Label grid3Caption = new Label("Search results");
        grid3Caption.setWrapText(true);

        // create text area for console output
        TextArea ta = new TextArea();
        ta.setPrefWidth(800);
        ta.prefHeight(600);
        ta.setWrapText(true);

        Console console = new Console(ta);
        PrintStream ps = new PrintStream(console);
        System.setOut(ps);
        System.setErr(ps);

        vbox.getChildren().addAll(grid3Caption, ta);

        root.getChildren().add(vbox);
    }
}