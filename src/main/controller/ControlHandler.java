package controller;

import controller.Actions.*;
import controller.MapMakerControlSubsystem.MMCState;
import javafx.scene.input.KeyCode;
import view.Camera;
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
    private Camera camera;

    public void setCamera(Camera camera){this.camera = camera;}

    public void addCameraActions(){

        addAction(new ZoomIn(this,camera), new KeyListener(KeyCode.EQUALS));

        addAction(new ZoomOut(this, camera), new KeyListener(KeyCode.MINUS));
        addAction(new CameraMoveUp(this,camera), new KeyListener(KeyCode.I));
        addAction(new CameraMoveDown(this, camera), new KeyListener(KeyCode.K));
        addAction(new CameraMoveRight(this, camera), new KeyListener(KeyCode.L));
        addAction(new CameraMoveLeft(this, camera), new KeyListener(KeyCode.J));
    }

    public void addAction(Action action, KeyListener keyListener){

        //adding action to actions vector
        actions.add(action);

        //attaching action to the passed KeyListener object and
        action.attachToController(keyListener);

        // adding the KeyListener to the ControlHandler.kLSet
        kLSet.add(keyListener);

    }

    public Vector<KeyListener> getKLSet(){
        return kLSet;
    }


    public void moveMapUp(Camera camera){
        camera.moveUpMap();
    }

    public void moveMapDown(Camera camera){
        camera.moveDownMap();
    }

    public void moveMapLeft(Camera camera){
        camera.moveLeftMap();
    }

    public void moveMapRight(Camera camera){
        camera.moveRightMap();
    }

    public void cameraZoomIn(Camera camera){camera.zoomIn();}

    public void cameraZoomOut(Camera camera){camera.zoomOut();}



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

    //upAndDown
    public abstract void up();
    public abstract void down();

    //utilities
    public abstract void delete();
    public abstract void reset();
    public abstract void centerGravity();

    //initialisers
    //TODO try to remove it
    public abstract void init(MapMakerPreview preview, Camera camera);



}
