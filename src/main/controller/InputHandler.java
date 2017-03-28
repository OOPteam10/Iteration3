package controller;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Vector;

/**
 * Created by rishabh on 28/03/17.
 */
public class InputHandler {


    private static Controller controller;
    private static Vector<KeyCode> activeKeys;



    static {

        controller = new Controller();
        activeKeys = new Vector<KeyCode>();

    }

    public static void keyPress(KeyEvent event){

        if(!activeKeys.contains(event.getCode()))
            activeKeys.add(event.getCode());

        keyPressDispatch();

    }


    public static void keyPressDispatch(){

        if(activeKeys.contains(KeyCode.J)){
            controller.right();
        }
        if(activeKeys.contains(KeyCode.K) ){
            //left
            controller.left();
        }
        if(activeKeys.contains(KeyCode.ENTER)){
            //enter
            controller.select();
        }
        if(activeKeys.contains(KeyCode.W)){
            //W maps to north
            controller.moveN();
        }
        if(activeKeys.contains(KeyCode.E)){
            //E maps to north east
            controller.moveNE();
        }
        if(activeKeys.contains(KeyCode.Q)){
            //Q maps to north west
            controller.moveNW();
        }
        if(activeKeys.contains(KeyCode.S)){
            //S maps to south
            controller.moveS();
        }
        if(activeKeys.contains(KeyCode.D)) {
            //D maps to south east
            controller.moveSE();
        }
        if(activeKeys.contains(KeyCode.A)) {
            //A maps to south west
            controller.moveSW();
        }


    }

    public static void keyRelease(KeyEvent event){

        activeKeys.remove(event.getCode());
    }




}
