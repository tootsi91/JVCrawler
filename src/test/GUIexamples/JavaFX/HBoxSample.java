package main.Tests.GUIexamples.JavaFX;

/**
 * Copyright (c) 2008, 2012 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
/**
 * An example of an HBox layout.
 *
 * @see javafx.scene.layout.HBox
 * @related controls/text/SimpleLabel
 */
public class HBoxSample extends Application {

    private void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 400,100));

        //Controls to be added to the HBox
        Label label = new Label("Test Label:");
        TextField tb = new TextField();
        Button button = new Button("Button...");

        //HBox with spacing = 5
        HBox hbox = new HBox(5);
        hbox.getChildren().addAll(label, tb, button);
        hbox.setAlignment(Pos.CENTER);
        root.getChildren().add(hbox);
    }

    public double getSampleWidth() { return 400; }

    public double getSampleHeight() { return 100; }

    @Override public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
    }
    public static void main(String[] args) { launch(args); }
}
