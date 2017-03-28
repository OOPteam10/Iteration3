import controller.Controller;
import controller.InputHandler;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Game;
import view.View;

import java.util.Vector;

public class GameEngine extends Application {

    private static final int MIN_HEIGHT = 768;
    private static final int MIN_WIDTH = 1024;

    private View view;
    private Game game;

    private int frameCounter = 0;
    private Vector<KeyCode> activeKeys;





    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("MapMakerV0.2");
        Group root = new Group();
        Scene scene = new Scene(root, Color.WHITE);

        //array for active keyCodes
        activeKeys = new Vector<KeyCode>();


        game = new Game();
        view = new View(game, scene, root);


        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

               
                //functionality on keypresses
               InputHandler.keyPress(event);



            }
        });


        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                //functionality on key release
                InputHandler.keyRelease(event);
            }
        });



        new AnimationTimer() {
            @Override
            public void handle(long currentPulse) {
                frameCounter++;
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
}
