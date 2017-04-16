package controller;

import controller.Actions.*;

import controller.MapMakerControlSubsystem.MMCObserver;
import controller.MapMakerControlSubsystem.MMCState;

import javafx.scene.input.KeyCode;
import model.Game;
import utilities.TileEditor;
import view.Camera;
import view.MapMakerPreview;

import java.util.Vector;

/**
 * Created by rishabh on 26/03/17.
 */

//represents top level state of Controller
public abstract class  ControlHandler {

    //reference to the Controller so that all handlers can change the Controller state to a different phase
    private Controller controller;
    private Vector<Action> actions = new Vector<Action>() ;
    private Vector<KeyListener> kLSet = new Vector<KeyListener>();
    private Camera camera;
    private MapMakerPreview preview;
    private Game game;
    private Vector<MMCObserver> mmcObservers =  new Vector<MMCObserver>();


    public ControlHandler(Controller controller, Game game, MapMakerPreview preview, Camera camera) {

        this.camera = camera;
        this.controller = controller;
        this.game = game;
        this.preview = preview;
        mmcObservers.add(preview);
        addCommonActions();

    }

    //defalut constructor do not remove, For singleton MapMakerControl
    public ControlHandler() {
        addCommonActions();
    }


    public void addCommonActions(){

        addAction(new MoveNorth(this), new KeyListener(KeyCode.W));
        addAction(new MoveNW(this), new KeyListener(KeyCode.Q));
        addAction(new MoveNE(this), new KeyListener(KeyCode.E));
        addAction(new MoveSouth(this), new KeyListener(KeyCode.S));
        addAction(new MoveSW(this), new KeyListener(KeyCode.A));
        addAction(new MoveSE(this), new KeyListener(KeyCode.D));
        addAction(new Select(this), new KeyListener(KeyCode.ENTER));
        addAction(new CycleLeft(this), new KeyListener(KeyCode.LEFT));
        addAction(new CycleRight(this), new KeyListener(KeyCode.RIGHT));
        addAction(new EndTurn(this), new KeyListener(KeyCode.P));

        //camera actions
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

    //getters setters
    public void setController(Controller controller) {
        this.controller = controller;
    }
    public Controller getController(){
        return controller;
    }
    public void setCamera(Camera camera){
        this.camera = camera;
    }
    public Vector<MMCObserver> getMmcObservers(){
        return mmcObservers;
    }
    public Game getGame(){
        return game;
    }
    public MapMakerPreview getPreview(){
        return preview;
    }
    public Camera getCamera(){
        return camera;
    }
    public void setPreview(MapMakerPreview preview) {
        this.preview = preview;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Vector<KeyListener> getKLSet(){
        return kLSet;
    }

    public void moveMapUp(Camera camera){
        System.out.println("camera up");camera.moveUpMap();
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



    //movement
    public void moveNW(){

        TileEditor.getInstance().moveNW();
        for(int i =0;i<mmcObservers.size();i++){
            mmcObservers.get(i).updateCursorNW();
        }
    }
    public void moveN(){

        TileEditor.getInstance().moveN();
        for(int i =0;i<mmcObservers.size();i++){
            mmcObservers.get(i).updateCursorN();
        }
    }
    public void moveNE(){

        TileEditor.getInstance().moveNE();
        for(int i =0;i<mmcObservers.size();i++){
            mmcObservers.get(i).updateCursorNE();
        }
    }

    public void moveSW(){

        TileEditor.getInstance().moveSW();
        for(int i =0;i<mmcObservers.size();i++){
            mmcObservers.get(i).updateCursorSW();
        }
    }
    public void moveS(){

        TileEditor.getInstance().moveS();
        for(int i =0;i<mmcObservers.size();i++){
            mmcObservers.get(i).updateCursorS();
        }
    }
    public void moveSE(){

        TileEditor.getInstance().moveSE();
        for(int i =0;i<mmcObservers.size();i++){
            mmcObservers.get(i).updateCursorSE();
        }
    }

    //abstract methods
    //cycling
    public abstract void left();
    public abstract void right();
    public abstract void select();

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
    public abstract void endTurn();

    //initialisers
    //TODO try to remove it
    public abstract void init(Controller controller,Game game,MapMakerPreview preview, Camera camera);



}
