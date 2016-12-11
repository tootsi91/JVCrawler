/**
 * Copyright (c) 2008, 2012 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import static java.lang.Math.round;
import static java.lang.Math.random;

/**
 * A sample that demonstrates the ObservableList interface, which extends the
 * java.util.List interface. Click the button to change an integer to a new
 * random number in a random position in the list. Once you add a listener,
 * the index of the changed number is displayed to the left of the list.
 *
 * @see javafx.beans.value.ChangeListener
 * @see javafx.collections.FXCollections
 * @see javafx.collections.ListChangeListener
 * @see javafx.collections.ObservableList
 */
public class ObservableListSample extends Application {

    private void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 400,80));

        //create some list with integers
        final List<Integer> listData = new ArrayList<Integer>();
        for (int i=1; i<10; i++) {
            listData.add(i);
        }

        //create observable list from this list of integers by static method of FXCollections class
        final ObservableList<Integer> list = FXCollections.<Integer>observableList(listData);

        //create text for showing observable list content
        final Text textList = new Text(0,0, list.toString());
        textList.setStyle("-fx-font-size: 16;");
        textList.setTextOrigin(VPos.TOP);
        textList.setTextAlignment(TextAlignment.CENTER);

        //create text field for showing  message
        final Text textMessage = new Text(0,0, "please add a listener");
        textMessage.setStyle("-fx-font-size: 16;");
        textMessage.setTextOrigin(VPos.TOP);
        textMessage.setTextAlignment(TextAlignment.CENTER);

        //create button for adding random integer to random position in observable list
        Button buttonAddNumber = new Button("Replace randomly integer in list");
        buttonAddNumber.setPrefSize(190, 20);
        buttonAddNumber.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent t) {
                int randomIndex = (int) (round(random() * list.size()));
                int randomNumber = (int) (round(random()*10));
                list.set(randomIndex, randomNumber );
                //actualise content of the text to see the result
                textList.setText(list.toString());
            }
        });

        //create button for adding listener
        Button buttonAdd = new Button("Add list listener");
        buttonAdd.setPrefSize(190, 20);
        final ListChangeListener<Integer> listener = new ListChangeListener<Integer>() {
            public void onChanged(Change<? extends Integer> c) {
                while (c.next()) {
                    textMessage.setText("replacement on index "  + c.getFrom());
                }
            }
        };

        buttonAdd.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                list.addListener(listener);
                textMessage.setText("listener added");
            }
        });

        //create a button for removing the listener
        Button buttonRemove = new Button("Remove list listener");
        buttonRemove.setPrefSize(190, 20);
        buttonRemove.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent t) {
                //remove the listener
                list.removeListener(listener);
                textMessage.setText("listener removed");
            }
        });

        // show all nodes
        VBox vBoxLeft = new VBox();
        vBoxLeft.setSpacing(10);

        VBox vBoxRight = new VBox();
        vBoxRight.setSpacing(10);
        vBoxRight.setLayoutX(230);
        vBoxRight.setLayoutY(30);

        vBoxLeft.getChildren().addAll(buttonAdd, buttonRemove, textMessage);
        vBoxRight.getChildren().addAll(buttonAddNumber, textList);
        root.getChildren().addAll(vBoxLeft, vBoxRight);
    }

    public double getSampleWidth() { return 400; }

    public double getSampleHeight() { return 80; }

    @Override public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
    }
    public static void main(String[] args) { launch(args); }
}