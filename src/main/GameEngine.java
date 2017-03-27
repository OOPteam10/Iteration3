import controller.Controller;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Game;
import view.View;

public class GameEngine extends Application {

    private static final int MIN_HEIGHT = 768;
    private static final int MIN_WIDTH = 1024;

    private View view;
    private Game game;
    private Controller controller;

    private int frameCounter = 0;

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("MapMapkerV0.2");
        Group root = new Group();
        Scene scene = new Scene(root, Color.WHITE);

        game = new Game();
        controller = new Controller();
        view = new View();

        new AnimationTimer() {
            @Override
            public void handle(long currentPulse) {
                frameCounter++;
                if (frameCounter == 2) { //Limit FPS to 30
                    frameCounter = 0;

                }

            }
        }.start();

        primaryStage.setMinWidth(MIN_WIDTH);
        primaryStage.setMinHeight(MIN_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
