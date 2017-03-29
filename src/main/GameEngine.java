import controller.Controller;
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
import view.Camera;
import view.View;

import java.util.Vector;

public class GameEngine extends Application {

    private static final int MIN_HEIGHT = 768;
    private static final int MIN_WIDTH = 1024;

    private View view;
    private Game game;
    private Controller controller;

    private int frameCounter = 0;
    private Vector<KeyCode> activeKeys;

    boolean scrollLeft,scrollRight,goNorth,goNE,goNW,goSouth,goSE,goSW,select;



    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("MapMakerV0.2");
        Group root = new Group();
        Scene scene = new Scene(root, Color.TRANSPARENT);

        //array for active keyCodes
        activeKeys = new Vector<KeyCode>();


        game = new Game();
        view = new View(game, scene, root);




        controller  = new Controller(view);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                switch(event.getCode()) {
                    case J:
                        scrollLeft = true;
                        break;
                    case K:
                        scrollRight = true;
                        break;
                    case W:
                        goNorth = true;
                        break;
                    case E:
                        goNE = true;
                        break;
                    case Q:
                        goNW = true;
                        break;
                    case S:
                        goSouth = true;
                        break;
                    case D:
                        goSE = true;
                        break;
                    case A:
                        goSW = true;
                        break;
                    case ENTER:
                        select = true;
                        break;
                }


            }
        });


        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                switch(event.getCode()) {
                    case J:
                        scrollLeft = false;
                        break;
                    case K:
                        scrollRight = false;
                        break;
                    case W:
                        goNorth = false;
                        break;
                    case E:
                        goNE = false;
                        break;
                    case Q:
                        goNW = false;
                        break;
                    case S:
                        goSouth = false;
                        break;
                    case D:
                        goSE = false;
                        break;
                    case A:
                        goSW = false;
                        break;
                    case ENTER:
                        select = false;
                        break;
                }

            }
        });



        new AnimationTimer() {
            @Override
            public void handle(long currentPulse) {


                frameCounter++;
                //menus
                if (frameCounter == 6) { //Limit FPS to 30
                    frameCounter = 0;
                    if(scrollLeft){ System.out.println("left");controller.left();}
                    if(scrollRight) {controller.right();}

                    //movement
                    if(goNorth) {controller.moveN();}
                    if(goNE) {controller.moveNE();}
                    if(goNW) {controller.moveNW();}
                    if(goSouth) {controller.moveS();}
                    if(goSE) {controller.moveSE();}
                    if(goSW) {controller.moveSW();}

                    //selesction
                    if(select) {controller.select();}


                    view.renderGame();
                }
            }
        }.start();

        primaryStage.setMinWidth(MIN_WIDTH);
        primaryStage.setMinHeight(MIN_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    public void keyRelease(KeyEvent event){

        activeKeys.remove(event.getCode());
    }


    public void keyRelase(KeyEvent e){

    }



}
