package controller.MovePhaseControlSubsystem;

import controller.ControlHandler;
import model.Managers.*;

import model.Transporters.Donkey;
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
public class MovePhaseControl implements ControlHandler {

    private ArrayList<MovePhaseControlMode> movePhaseControlModes;
    MovePhaseControlMode currentMovePhaseControlMode;

    private LandTransporterManager landTransporterManager;
    private SeaTransporterManager seaTransporterManager;
    private SeaTransporterShoreManager seaTransporterShoreManager;
    private SectorAdjacencyManager sectorAdjacencyManager;
    private SectorAdjacencyManager roadAdjacencyManager;
    private ResourceManager resourceManager;
    private CargoManager cargoManager;

    public MovePhaseControl(LandTransporterManager landTransporterManager, SeaTransporterManager seaTransporterManager,
                            SeaTransporterShoreManager seaTransporterShoreManager,
                            SectorAdjacencyManager sectorAdjacencyManager, SectorAdjacencyManager roadAdjacencyManager,
                            ResourceManager resourceManager, CargoManager cargoManager, ArrayList<Donkey> donkeys
                            ){
        this.landTransporterManager = landTransporterManager;
        this.seaTransporterManager = seaTransporterManager;
        this.seaTransporterShoreManager = seaTransporterShoreManager;
        this.sectorAdjacencyManager = sectorAdjacencyManager;
        this.roadAdjacencyManager = roadAdjacencyManager;
        this.resourceManager = resourceManager;
        this.cargoManager = cargoManager;
        movePhaseControlModes = new ArrayList<MovePhaseControlMode>();
        movePhaseControlModes.add(new DonkeyMPCMode(donkeys, this));
        currentMovePhaseControlMode = movePhaseControlModes.get(0);
    }

    private void nextMode(){
        int next = (movePhaseControlModes.indexOf(currentMovePhaseControlMode)+1)
                % movePhaseControlModes.size();
        currentMovePhaseControlMode = movePhaseControlModes.get(next);
        currentMovePhaseControlMode.resetCurrentMPCInstructionState();
    }
    private void previousMode(){
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
    public void left() {
        previousMode();
    }

    @Override
    public void right() {
        nextMode();
    }

    @Override
    public void select() {

        currentMovePhaseControlMode.select();

    }

    @Override
    public void moveNW() {
        cycleLeft();

    }

    @Override
    public void moveN() {
        cycleRight();
    }

    @Override
    public void moveNE() {

    }

    @Override
    public void moveSW() {
        previousTransporter();
    }

    @Override
    public void moveS() {
        nextTransporter();
    }

    @Override
    public void moveSE() {

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
    public void init(MapMakerPreview preview) {

    }

    //testing
    public String toString(){
        String s = "";
        s += ("Mode: " + currentMovePhaseControlMode.toString() + " # " + currentMovePhaseControlMode.currentIndex() +
                " Instruction: " + currentMovePhaseControlMode.getCurrentMPCInstructionState().toString());
        return s;
    }
}
