package controller;

import controller.MapMakerControlSubsystem.MMCState;
import view.MapMakerPreview;
import view.View;

import java.util.Vector;

/**
 * Created by rishabh on 26/03/17.
 */

//represents top level state of Controller
public abstract class  ControlHandler {

    private Vector<Action> actions = new Vector<Action>() ;
    private Vector<KeyListener> kLSet = new Vector<KeyListener>();


    public void addAction(Action action, KeyListener keyListener){

        //adding action to actions vector
        actions.add(action);

        //attaching action to the passed KeyListener object and
        action.attachToController(keyListener);

        // adding the KeyListener to the ControlHandler.kLSet
        kLSet.add(keyListener);

    }

    /*public void addToKLSet(KeyListener keyListener){
        kLSet.add(keyListener);
    }
    */
    //abstract methods
    //cycling
    public abstract void left();
    public abstract void right();
    public abstract void select();

    //movement
    public abstract void moveNW();
    public abstract void moveN();
    public abstract void moveNE();
    public abstract void moveSW();
    public abstract void moveS();
    public abstract void moveSE();

    //modes
    public abstract void nextMode();
    public abstract void prevMode();

    //utilities
    public abstract void delete();
    public abstract void reset();
    public abstract void centerGravity();

    //initialisers
    //TODO try to remove it
    public abstract void init(MapMakerPreview preview);


}
