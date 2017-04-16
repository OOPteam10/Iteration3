import controller.Controller;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Game;
import view.View;

public class GameEngine extends Application {

    private static final int MIN_HEIGHT = 400;
    private static final int MIN_WIDTH = 800;

    private View view;
    private Game game;
    private Controller controller;

    private int frameCounter = 0;

    private Group root;
    private Scene scene;

    public GameEngine(){
         root = new Group();
         scene = new Scene(root, Color.TRANSPARENT);

        //array for active keyCodes
        game = new Game();
        view = new View(game, scene, root);

        controller  = new Controller(game,view);
    }

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("MapMakerV0.2");

        sendEventToController(scene);

        new AnimationTimer() {
            @Override
            public void handle(long currentPulse) {
                frameCounter++;

                //menus
                if (frameCounter == 2) { //Limit FPS to 30
                    frameCounter = 0;

                    view.renderGame();
                }
            }
        }.start();

        primaryStage.setMinWidth(MIN_WIDTH);
        primaryStage.setMinHeight(MIN_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void sendEventToController(Scene scene){

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

            }
        });


        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                controller.keyReleased(event);
            }
        });
    }
}
