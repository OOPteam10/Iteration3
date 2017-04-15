package controller;


import controller.Actions.CycleLeft;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import view.Camera;
import view.View;

import java.util.HashMap;
import java.util.Vector;

/**
 * Created by cduica on 3/22/17.
 */
public class Controller {

    //represents the top level state of Controller
    private ControlHandler controlHandler;

    //TODO remove commented out in future
    /*
    private HashMap<KeyCode, ControlAction> actionMap;
    private KeyMapControls controlMap;
    */
    private Camera camera;

    //new KeyMapping
    private Vector<KeyListener> currentKLSet = new Vector<KeyListener>();


    public Controller(View view){

        //camera
        camera = view.getCamera();

        //init with the MapMakerControl state

        controlHandler = MapMakerControl.getInstance();
        controlHandler.init(view.getMapMakerPreview(),camera);
        setCurrentKLSet(controlHandler);


    }


    public void setCurrentKLSet(ControlHandler controlHandler){currentKLSet = controlHandler.getKLSet();}

    public ControlHandler getControlHandler() {
        return controlHandler;
    }

    public void setControlHandler(ControlHandler controlHandler) {
        this.controlHandler = controlHandler;
    }

    public void executeCode(KeyCode code){


        for(int i =0; i <currentKLSet.size();i++) {

            if(currentKLSet.elementAt(i).getKeyCode().equals(code)){

                currentKLSet.elementAt(i).perform();

            }
        }
    }


    public void keyReleased(KeyEvent e){
        KeyCode key = e.getCode();
        executeCode(key);
    }






}
