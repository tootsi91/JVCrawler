package main.Tests.GUIexamples;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class Lab10 extends Application {
    Scene scene1, scene2;
    Stage stage1;
    private Button bInputSave = new Button("Save");
    private Button bAddCourse = new Button("Add Course");
    private Button bClose = new Button("Close");
    private Button bInputCancel = new Button("Cancel");
    private TextField input = new TextField();
    ListView<String> list;

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        stage1 = primaryStage;
        list = new ListView<>();

        //Button Actions
        bAddCourse.setOnAction(event -> stage1.setScene(scene2));
        bClose.setOnAction(e -> stage1.close());

        //First Layout
        HBox layout1 = new HBox(30);
        layout1.getChildren().addAll(bAddCourse, bClose);
        layout1.setAlignment(Pos.BOTTOM_RIGHT);
        scene1 = new Scene(layout1, 400, 300);
        list.setPrefHeight(200);
        list.setPrefWidth(200);

        //Second Layout
        GridPane gridpane = new GridPane();
        GridPane.setHalignment(bInputCancel, HPos.RIGHT);
        GridPane.setHalignment(bInputSave, HPos.RIGHT);
        gridpane.setHgap(5);
        gridpane.setVgap(5);
        gridpane.add(new Label("Course Name: "), 0, 0); //y=0, x=0
        gridpane.add(input, 1, 0);
        gridpane.add(bInputSave, 1, 1);
        gridpane.add(bInputCancel, 1, 2);
        gridpane.setAlignment(Pos.CENTER);
        scene2 = new Scene(gridpane, 400, 300);
        input.setEditable(true);
        input.setAlignment(Pos.BOTTOM_RIGHT);
        bInputCancel.setOnAction(e -> stage1.setScene(scene1));
        bInputSave.setOnAction(e -> buttonClick());


        stage1.setTitle("LAB 10 GUI");
        stage1.setScene(scene1);
        stage1.show();
    }
    private void buttonClick() {//method to handle Save button click.
        bInputSave.setOnAction(event -> stage1.setScene(scene1));//this works. It returns to the first scene.
        String userInput = input.getText();//Shouldn't this get the input from the TextField?
        list.getItems().addAll(userInput);//tried this to add the input to the list. Nope.
        input.clear();//thought this would clear the text after clicking "Save". Nope.

    }
}
