package controller.MapMakerControlSubsystem;

import controller.KeyListener;
import view.MapMakerPreview;

import java.util.Vector;

/**
 * Created by rishabh on 11/04/17.
 */
public abstract class MapMakerControlHandler {

    private Vector<KeyListener> currentKLSet;

    public void addToKLSet(KeyListener keyListener){
        currentKLSet.add(keyListener);
    }
    public Vector<KeyListener> getKLSet(){
        return currentKLSet;
    }

    public abstract void left();
    public abstract void right();
    public abstract void select();
    public abstract void moveNW();
    public abstract void moveN();
    public abstract void moveNE();
    public abstract void moveSW();
    public abstract void moveS();
    public abstract void moveSE();

    public abstract void delete();
    public abstract void reset();
    public abstract void centerGravity();

    public abstract void init(MapMakerPreview preview);

}
