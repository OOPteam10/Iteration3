package controller;

import controller.MapMakerControlSubsystem.MMCState;
import view.MapMakerPreview;
import view.View;

/**
 * Created by rishabh on 26/03/17.
 */

//represents top level state of Controller
public interface ControlHandler {

    public void left();
    public void right();
    public void select();
    public void moveNW();
    public void moveN();
    public void moveNE();
    public void moveSW();
    public void moveS();
    public void moveSE();

    public void delete();
    public void reset();
    public void centerGravity();

    public void init(MapMakerPreview preview);
    public void addToKLSet(KeyListener keyListener);

}
