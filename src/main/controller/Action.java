package controller;

/**
 * Created by rishabh on 07/04/17.
 */
public abstract class Action {

    private ControlHandler controlHandler;

    public Action(ControlHandler controlHandler) {
        this.controlHandler = controlHandler;
    }

    public ControlHandler getControlHandler(){
        return controlHandler;
    }

    public void attachToController(KeyListener keyListener){

        keyListener.setAction(this);

    }

    public abstract void perform();




}
