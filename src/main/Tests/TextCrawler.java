package main.Tests;


import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class TextCrawler extends Application {

    private static final String crawl = "Episode IV\n"
            + "A NEW HOPE\n"
            + "It is a period of civil war.\n"
            + "Rebel spaceships, striking\n"
            + "from a hidden base, have won\n"
            + "their first victory against\n"
            + "the evil Galactic Empire.\n"
            + "\n"
            + "During the battle, Rebel\n"
            + "spies managed to steal secret\n"
            + "plans to the Empire's\n"
            + "ultimate weapon, the DEATH\n"
            + "STAR, an armored space\n"
            + "station with enough power\n"
            + "to destroy an entire planet.\n"
            + "\n"
            + "Pursued by the Empire's\n"
            + "sinister agents, Princess\n"
            + "Leia races home aboard her\n"
            + "starship, custodian of the\n"
            + "stolen plans that can save her\n"
            + "people and restore\n"
            + "freedom to the galaxy....";

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        root.setTranslateX(400);
        root.setTranslateY(50);
        Scene scene = new Scene(root);
        scene.setCamera(new PerspectiveCamera());
        scene.setFill(Color.BLACK);
        stage.setScene(scene);
        stage.setWidth(800);
        stage.setHeight(600);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();

        Text text = new Text(crawl);
        text.setTextAlignment(TextAlignment.CENTER);
        text.setFill(Color.YELLOW);
        text.setFont(Font.font("Arial", FontPosture.REGULAR, 24));
        text.setRotationAxis(new Point3D(1.0, 0.0, 0.0));
        text.setRotate(-80.0);
        text.setTranslateX(-150);
        root.getChildren().add(text);

        TranslateTransition trans = new TranslateTransition(Duration.millis(20_000), text);
        trans.setFromY(200);
        trans.setFromZ(-1_000);
        trans.setToY(0);
        trans.setToZ(1_000);
        trans.setInterpolator(Interpolator.LINEAR);
        trans.setCycleCount(Animation.INDEFINITE);
        trans.play();
    }

    public static void main(String... args) {
        launch(args);
    }
}

