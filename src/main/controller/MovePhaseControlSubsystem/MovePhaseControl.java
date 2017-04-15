package controller.MovePhaseControlSubsystem;

import controller.ControlHandler;
import model.Game;
import model.Managers.*;

import model.TileSubsystem.Sector;
import model.TileSubsystem.Waterway;
import model.TransporterControlAbilities.AddTransporterToControlListFactory;
import model.Transporters.Donkey;
import model.Transporters.LandTransporter;
import model.Transporters.RoadTransporter;
import model.Transporters.SeaTransporter;
import view.Camera;
import view.MapMakerPreview;

import java.util.ArrayList;
import java.util.Map;

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
    private WaterwayAdjacencyManager waterwayAdjacencyManager;
    private SectorToWaterwayManager sectorToWaterwayManager;
    private WaterwayToSectorManager waterwayToSectorManager;

    private ArrayList<Donkey> donkeyList = new ArrayList<Donkey>();
    private ArrayList<RoadTransporter> roadTransporterList = new ArrayList<RoadTransporter>();
    private ArrayList<SeaTransporter> seaTransporterList = new ArrayList<SeaTransporter>();

    public MovePhaseControl(Game game){
        this.landTransporterManager = game.getLandTransporterManager();
        this.seaTransporterManager = game.getSeaTransporterManager();
        this.seaTransporterShoreManager = game.getSeaTransporterShoreManager();
        this.sectorAdjacencyManager = game.getSectorAdjacencyManager();
        this.roadAdjacencyManager = game.getRoadAdjacencyManager();
        this.resourceManager = game.getResourceManager();
        this.cargoManager = game.getCargoManager();
        this.waterwayAdjacencyManager = game.getWaterwayAdjacencyManager();
        this.sectorToWaterwayManager = game.getSectorToWaterwayManager();
        this.waterwayToSectorManager = game.getWaterwayToSectorManager();
        movePhaseControlModes = new ArrayList<MovePhaseControlMode>();
    }

    public void addDonkeyMPCMode(){
        clearTransporterLists();
        configureTransporterLists();
        movePhaseControlModes.add(new DonkeyMPCMode(donkeyList, this));
        currentMovePhaseControlMode = movePhaseControlModes.get(0);
    }

    public void addRoadTransporterMPCMode(){
        clearTransporterLists();
        configureTransporterLists();
        movePhaseControlModes.add(new RoadTransporterMPCMode(roadTransporterList, this));
    }

    public void addSeaTransporterMPCMode(){
        clearTransporterLists();
        configureTransporterLists();
        movePhaseControlModes.add(new SeaTransporterMPCMode(seaTransporterList, this));
    }

    public void nextMode(){
        int next = (movePhaseControlModes.indexOf(currentMovePhaseControlMode)+1)
                % movePhaseControlModes.size();
        currentMovePhaseControlMode = movePhaseControlModes.get(next);
        currentMovePhaseControlMode.resetCurrentMPCInstructionState();
    }

    @Override
    public void prevMode() {

    }

    @Override
    public void up() {

    }

    @Override
    public void down() {

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

    public WaterwayAdjacencyManager getWaterwayAdjacencyManager() {return waterwayAdjacencyManager;}

    public SectorToWaterwayManager getSectorToWaterwayManager() {return sectorToWaterwayManager;}

    public WaterwayToSectorManager getWaterwayToSectorManager() {return waterwayToSectorManager;}

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
    public void init(MapMakerPreview preview, Camera camera) {

    }

    public void addToDonkeyList(Donkey donkey) {
        donkeyList.add(donkey);
    }

    public void addToRoadTransporterList(RoadTransporter rt) {
        roadTransporterList.add(rt);
    }

    public void addToSeaTransporterList(SeaTransporter st) {
        seaTransporterList.add(st);
    }

    public void clearTransporterLists() {
        donkeyList.clear();
        roadTransporterList.clear();
        seaTransporterList.clear();
    }

    public void configureTransporterLists() {
        for(LandTransporter lt : landTransporterManager.getManagerMap().keySet()) {
            lt.produceAbility(new AddTransporterToControlListFactory(this));
            lt.execute(); // adds to donkey/road transporter list
        }
        for (SeaTransporter st : seaTransporterManager.getManagerMap().keySet()) {
            // add this to the factory
            seaTransporterList.add(st);
        }
    }

    //testing
    public String toString(){
        String s = "";
        s += ("Mode: " + currentMovePhaseControlMode.toString() + " # " + currentMovePhaseControlMode.currentIndex() +
                " Instruction: " + currentMovePhaseControlMode.getCurrentMPCInstructionState().toString());
        return s;
    }
}
