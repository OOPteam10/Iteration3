package controller;





import controller.Actions.*;

import controller.BuildPhaseControlSubsystem.BuildPhaseControl;

import controller.MovePhaseControlSubsystem.MovePhaseControl;
import controller.MovePhaseControlSubsystem.MovePhaseControlObserver;
import controller.WonderPhaseControlSubsystem.WonderPhaseControl;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.Game;
import view.Camera;
import view.MapMakerPreview;
import view.MovementPhasePreview;
import view.View;


import java.util.ArrayList;

import java.util.Vector;

/**
 * Created by cduica on 3/22/17.
 */
public class Controller {

    //represents the top level state of Controller
    private ArrayList<ControlHandler> controlHandlers = new ArrayList<ControlHandler>();

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
        MapMakerControl.getInstance().init(this,game,view.getMapMakerPreview());
        Vector<MovePhaseControlObserver> movePhaseControlObservers = new Vector<MovePhaseControlObserver>();


        controlHandler = MapMakerControl.getInstance();
        addCameraActions(camera);
        //camera actions

        MovementPhasePreview movementPhasePreview = view.getMovementPhasePreview();
        movePhaseControlObservers.add(movementPhasePreview);
        setCurrentKLSet(controlHandler);

        MovePhaseControl mpc = new MovePhaseControl(this,game,movePhaseControlObservers);
        mpc.addDonkeyMPCMode();
        mpc.addRoadTransporterMPCMode();
        mpc.addSeaTransporterMPCMode();

        controlHandlers.add(mpc);
        controlHandlers.add(new BuildPhaseControl(this,game));
        controlHandlers.add(new WonderPhaseControl(this,game));
    }

    public void nextHandler(){
        int next = (controlHandlers.indexOf(controlHandler)+1)
                % controlHandlers.size();
        controlHandler = controlHandlers.get(next);
        setCurrentKLSet(controlHandler);
        //this gets added to the controller's current KLSet, no need to add
        addCameraActions(camera);
        //this method needs to change the model's phase as well
    }

    public void firstHandler(){
        controlHandler = controlHandlers.get(0);
        setCurrentKLSet(controlHandler);
        //this gets added to the controller's current KLSet, no need to add
        addCameraActions(camera);
        //this method needs to change the model's phase as well
    }

    public void executeCode(KeyCode code){


        for(int i =0; i <currentKLSet.size();i++) {

            if(currentKLSet.elementAt(i).getKeyCode().equals(code)){

                currentKLSet.elementAt(i).perform();

            }
        }
    }

    public void addCameraActions(Camera camera){

        controlHandler.addAction(new ZoomIn(controlHandler,camera), new KeyListener(KeyCode.EQUALS));
        controlHandler.addAction(new ZoomOut(controlHandler,camera), new KeyListener(KeyCode.MINUS));
        controlHandler.addAction(new CameraMoveUp(controlHandler,camera), new KeyListener(KeyCode.I));
        controlHandler.addAction(new CameraMoveDown(controlHandler, camera), new KeyListener(KeyCode.K));
        controlHandler.addAction(new CameraMoveRight(controlHandler, camera), new KeyListener(KeyCode.L));
        controlHandler.addAction(new CameraMoveLeft(controlHandler, camera), new KeyListener(KeyCode.J));
    }

    public void keyReleased(KeyEvent e){
        KeyCode key = e.getCode();
        executeCode(key);
    }

    public void changeState(ControlHandler controlHandler){
        this.controlHandler = controlHandler;
        setCurrentKLSet(controlHandler);
        //this gets added to the controller's current KLSet, no need to add
        addCameraActions(camera);

        //this method needs to change the model's phase as well

    }

    //basic getter setters
    public void setCurrentKLSet(ControlHandler controlHandler){currentKLSet = controlHandler.getKLSet();}
    public ControlHandler getControlHandler() {
        return controlHandler;
    }


}
