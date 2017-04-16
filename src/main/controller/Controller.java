package controller;


import controller.Actions.CycleLeft;
import controller.MovePhaseControlSubsystem.MovePhaseControl;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.Game;
import view.Camera;
import view.View;

import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Vector;

/**
 * Created by cduica on 3/22/17.
 */
public class Controller {

    //represents the top level state of Controller
    private ControlHandler controlHandler;

    private Camera camera;
    private Game game;

    //new KeyMapping
    private Vector<KeyListener> currentKLSet = new Vector<KeyListener>();


    public Controller(Game game,View view){

        //camera
        camera = view.getCamera();
        this.game = game;
        //init with the MapMakerControl state
        controlHandler = MapMakerControl.getInstance();
        controlHandler.init(this,game,view.getMapMakerPreview(),camera);
        setCurrentKLSet(controlHandler);


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

    public void changeState(ControlHandler controlHandler){
        this.controlHandler = controlHandler;
        setCurrentKLSet(controlHandler);
    }

    //basic getter setters
    public void setCurrentKLSet(ControlHandler controlHandler){currentKLSet = controlHandler.getKLSet();}
    public ControlHandler getControlHandler() {
        return controlHandler;
    }


}
