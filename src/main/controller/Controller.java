package controller;

import controller.MapMakerControlSubsystem.ControlAction.ControlAction;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import view.View;

import java.util.HashMap;

/**
 * Created by cduica on 3/22/17.
 */
public class Controller {

    //represents the top level state of Controller
    private ControlHandler controlHandler;
    private HashMap<KeyCode, ControlAction> actionMap;
    private KeyMapControls controlMap;


    public Controller(View view){

        //init with the MapMakerControl state
        controlHandler = MapMakerControl.getInstance();
        controlHandler.init(view);
        controlMap = new KeyMapControls();

        actionMap = controlMap.getActionMap();
    }

    public void setActionMap(HashMap<KeyCode, ControlAction> actionMap){

        this.actionMap = actionMap;
    }

    public ControlHandler getControlHandler() {
        return controlHandler;
    }

    public void setControlHandler(ControlHandler controlHandler) {
        this.controlHandler = controlHandler;
    }

    public void executeCode(KeyCode code){
        for(KeyCode codeKey:actionMap.keySet()) {
            if(code == codeKey) {
                ControlAction action = actionMap.get(code);
                action.execute(this);
            }
        }
    }

    public void right(){

        controlHandler.right();
    }
    public void left(){

        controlHandler.left();
    }
    public void select(){

        controlHandler.select();
    }

    public void centerGravity(){

        controlHandler.centerGravity();
    }

    public void moveN(){

        controlHandler.moveN();
    }
    public void moveNE(){

        controlHandler.moveNE();
    }
    public void moveNW(){

        controlHandler.moveNW();
    }
    public void moveS(){

        controlHandler.moveS();
    }
    public void moveSE(){

        controlHandler.moveSE();
    }
    public void moveSW() {

        controlHandler.moveSW();
    }
    public void delete(){

        controlHandler.delete();
    }
    public void reset(){

        controlHandler.reset();
    }
    
    public void keyReleased(KeyEvent e){
        KeyCode key = e.getCode();
        executeCode(key);
    }

    public void keyPressed(KeyEvent e){

    }
}
