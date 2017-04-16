package controller.MovePhaseControlSubsystem;

import controller.ControlHandler;
import controller.Controller;
import model.Game;
import model.Managers.*;

import model.Transporters.Donkey;
import model.Transporters.RoadTransporter;
import view.Camera;
import view.MapMakerPreview;

import java.util.ArrayList;

/**
 * Created by hankerins on 4/10/17.
 *
 * we don't want singletons for the modes this time around, because
 * they should be created and destroyed based on whether or not the player
 * has the particular kind of transporter.
 *
 * the Control can hold an arraylist of the currently available modes (this is ok)
 */
public class MovePhaseControl extends ControlHandler {

    private ArrayList<MovePhaseControlMode> movePhaseControlModes;
    MovePhaseControlMode currentMovePhaseControlMode;

    private LandTransporterManager landTransporterManager;
    private SeaTransporterManager seaTransporterManager;
    private SeaTransporterShoreManager seaTransporterShoreManager;
    private SectorAdjacencyManager sectorAdjacencyManager;
    private SectorAdjacencyManager roadAdjacencyManager;
    private ResourceManager resourceManager;
    private CargoManager cargoManager;
    private SectorToWaterwayManager sectorToWaterwayManager;
    private WaterwayToSectorManager waterwayToSectorManager;

    public MovePhaseControl(Controller controller, Game game, MapMakerPreview mapMakerPreview, Camera camera){
        super(controller,game,mapMakerPreview,camera);
        this.landTransporterManager = game.getLandTransporterManager();
        this.seaTransporterManager = game.getSeaTransporterManager();
        this.seaTransporterShoreManager = game.getSeaTransporterShoreManager();
        this.sectorAdjacencyManager = game.getSectorAdjacencyManager();
        this.roadAdjacencyManager = game.getRoadAdjacencyManager();
        this.resourceManager = game.getResourceManager();
        this.cargoManager = game.getCargoManager();
        this.sectorToWaterwayManager = game.getSectorToWaterwayManager();
        this.waterwayToSectorManager = game.getWaterwayToSectorManager();
        movePhaseControlModes = new ArrayList<MovePhaseControlMode>();
    }


    public void addDonkeyMPCMode(ArrayList<Donkey> donkeys){
        movePhaseControlModes.add(new DonkeyMPCMode(donkeys, this));
        currentMovePhaseControlMode = movePhaseControlModes.get(0);
    }

    public void addRoadTransporterMPCMode(ArrayList<RoadTransporter> roadTransporters){
        movePhaseControlModes.add(new RoadTransporterMPCMode(roadTransporters, this));
    }

    private void nextMoveMode(){
        int next = (movePhaseControlModes.indexOf(currentMovePhaseControlMode)+1)
                % movePhaseControlModes.size();
        currentMovePhaseControlMode = movePhaseControlModes.get(next);
        currentMovePhaseControlMode.resetCurrentMPCInstructionState();
    }



    private void previousMoveMode(){
        int previous = (movePhaseControlModes.indexOf(currentMovePhaseControlMode)-1
                + movePhaseControlModes.size()) % movePhaseControlModes.size();
        currentMovePhaseControlMode = movePhaseControlModes.get(previous);
        currentMovePhaseControlMode.resetCurrentMPCInstructionState();
    }

    private void nextTransporter(){

        currentMovePhaseControlMode.nextTransporter();
        currentMovePhaseControlMode.resetCurrentMPCInstructionState();
    }

    private void previousTransporter(){
        currentMovePhaseControlMode.previousTransporter();
        currentMovePhaseControlMode.resetCurrentMPCInstructionState();
    }

    public void resetMPCInstructionStates(){
        for(MovePhaseControlMode mpcm: movePhaseControlModes){
            mpcm.resetCurrentMPCInstructionState();
        }
    }

    private void cycleLeft(){
        currentMovePhaseControlMode.cycleLeft();
    } //changes instruction or target

    private void cycleRight(){
        currentMovePhaseControlMode.cycleRight();
    } //changes instruction or target

    public ArrayList<MovePhaseControlMode> getMovePhaseControlModes() {
        return movePhaseControlModes;
    }

    public MovePhaseControlMode getCurrentMovePhaseControlMode() {
        return currentMovePhaseControlMode;
    }

    public LandTransporterManager getLandTransporterManager() {
        return landTransporterManager;
    }

    public SeaTransporterManager getSeaTransporterManager() {
        return seaTransporterManager;
    }

    public SeaTransporterShoreManager getSeaTransporterShoreManager() {return seaTransporterShoreManager;}

    public SectorAdjacencyManager getSectorAdjacencyManager() {
        return sectorAdjacencyManager;
    }

    public SectorAdjacencyManager getRoadAdjacencyManager() {
        return roadAdjacencyManager;
    }

    public ResourceManager getResourceManager() {return resourceManager;}

    public CargoManager getCargoManager() {return cargoManager;}

//TODO: All Overridden functions call meaningfully named functions
    //TODO: rename ControlHandler functions to the name of the keypress
    //right now mapped to functions kind of at random just to test


    @Override
    public void prevMode() {
        previousMoveMode();
    }
    @Override
    public void nextMode(){
        nextMoveMode();
    }


    @Override
    public void up() {
        nextTransporter();
    }

    @Override
    public void down() {
        previousTransporter();
    }


    @Override
    public void left() {
       cycleLeft();
    }

    @Override
    public void right() {
        cycleRight();
    }

    @Override
    public void select() {

        currentMovePhaseControlMode.select();

    }



    @Override
    public void delete() {

    }

    @Override
    public void reset() {

    }

    @Override
    public void centerGravity() {

    }

    @Override
    public void endTurn() {
        // will change the controller's state to next phase

    }

    @Override
    public void init(Controller controller, Game game, MapMakerPreview preview, Camera camera) {

    }




    //testing
    public String toString(){
        String s = "";
        s += ("Mode: " + currentMovePhaseControlMode.toString() + " # " + currentMovePhaseControlMode.currentIndex() +
                " Instruction: " + currentMovePhaseControlMode.getCurrentMPCInstructionState().toString());
        return s;
    }
}
