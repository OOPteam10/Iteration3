package controller;

/**
 * Created by rishabh on 07/04/17.
 */
public abstract class Action {

    private ControlHandler controlHandler;


    public void Action(ControlHandler controlHandler){
        this.controlHandler = controlHandler;
    }

    public ControlHandler getControlHandler(){
        return controlHandler;
    }

    public void attachToController(KeyListener keyListener){

        keyListener.setAction(this);

        //add this KeyListener to current controlHandler's KLSet
        controlHandler.addToKLSet(keyListener);

    }

    public abstract void perform();




}
