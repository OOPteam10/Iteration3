package controller;

import javafx.scene.input.KeyCode;

/**
 * Created by rishabh on 07/04/17.
 */
public class KeyListener {

    private Action action;
    private KeyCode keyCode;


    KeyListener(KeyCode keyCode){

        this.keyCode = keyCode;
    }

    KeyListener(KeyCode keyCode, Action action){
        this.keyCode = keyCode;
        this.action = action;
    }

    public void setAction(Action action){
        this.action = action;
    }

    public Action getAction(){return action;}

    public KeyCode getKeyCode(){
        return keyCode;
    }

    public void perform(){
        action.perform();
    }

}
