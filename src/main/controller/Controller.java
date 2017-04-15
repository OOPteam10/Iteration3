package controller;


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

        //init with the MapMakerControl state
        controlHandler = MapMakerControl.getInstance();
        controlHandler.init(view.getMapMakerPreview());
        setCurrentKLSet(controlHandler);

        //TODO remove commented ou tin future
        // controlMap = new KeyMapControls();
        //actionMap = controlMap.getActionMap();

        camera = view.getCamera();
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
                //ControlAction action = actionMap.get(code);
                //action.execute(this);
            }
        }
    }


    public void keyReleased(KeyEvent e){
        KeyCode key = e.getCode();
        executeCode(key);
    }


    public void moveMapUp(){
        camera.moveUpMap();
    }

    public void moveMapDown(){
        camera.moveDownMap();
    }

    public void moveMapLeft(){
        camera.moveLeftMap();
    }

    public void moveMapRight(){
        camera.moveRightMap();
    }

    public void cameraZoomIn(){camera.zoomIn();}

    public void cameraZoomOut(){camera.zoomOut();}




}
