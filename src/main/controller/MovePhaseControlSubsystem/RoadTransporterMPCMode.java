package controller.MovePhaseControlSubsystem;

import controller.MovePhaseControlSubsystem.MPCInstructionSubsystem.*;
import model.Managers.*;
import model.Transporters.LandTransporter;
import model.Transporters.RoadTransporter;
import model.Transporters.SeaTransporter;
import model.Transporters.Transporter;
import model.resources.Resource;
import model.structures.producers.Product;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by hankerins on 4/14/17.
 *
 *
 */
public class RoadTransporterMPCMode implements MovePhaseControlMode {
    private MPCInstructionState currentMPCInstructionState;
    private ArrayList<MPCInstructionState> mpcInstructionStates = new ArrayList<MPCInstructionState>();
    private RoadTransporter currentRoadTransporter;
    private ArrayList<RoadTransporter> roadTransporters;
    private LandTransporterManager landTransporterManager;
    private SeaTransporterShoreManager seaTransporterShoreManager;
    private SectorAdjacencyManager roadAdjacencyManager;
    private ResourceManager resourceManager;
    private CargoManager cargoManager;

    public RoadTransporterMPCMode(ArrayList<RoadTransporter> roadTransporters, MovePhaseControl context){
        this.roadTransporters = roadTransporters;
        currentRoadTransporter = roadTransporters.get(0);
        landTransporterManager = context.getLandTransporterManager();
        seaTransporterShoreManager = context.getSeaTransporterShoreManager();
        roadAdjacencyManager = context.getRoadAdjacencyManager();
        resourceManager = context.getResourceManager();
        cargoManager = context.getCargoManager();
        resetCurrentMPCInstructionState();
    }

    public void nextTransporter(Vector<MovePhaseControlObserver> observers) {
        int next = (roadTransporters.indexOf(currentRoadTransporter)+1)
                % roadTransporters.size();
        currentRoadTransporter = roadTransporters.get(next);
        for(MovePhaseControlObserver observer: observers){
            observer.highlightCurrentRoadTransporter(currentRoadTransporter);
        }
    }

    public void previousTransporter(Vector<MovePhaseControlObserver> observers) {
        int previous = (roadTransporters.indexOf(currentRoadTransporter)-1
                + roadTransporters.size()) % roadTransporters.size();
        currentRoadTransporter = roadTransporters.get(previous);
        for(MovePhaseControlObserver observer: observers){
            observer.highlightCurrentRoadTransporter(currentRoadTransporter);
        }
    }

    public void resetCurrentMPCInstructionState(){
        mpcInstructionStates.clear();
        if(roadAdjacencyManager.getAdjacency(landTransporterManager.getLocation(currentRoadTransporter)) != null){
            mpcInstructionStates.add(new MoveMPCIState());
        }
        if(resourceManager.getQuantityInArea(landTransporterManager.getLocation(currentRoadTransporter)) > 0){
            mpcInstructionStates.add(new PickUpResourceMPCIState());
        }
        if(cargoManager.getQuantityInArea(currentRoadTransporter) > 0){
            mpcInstructionStates.add(new DropOffMPCIState());
        }
        ArrayList<LandTransporter> others = landTransporterManager.getNeighbors(currentRoadTransporter);
        if(others.size() > 0){
            mpcInstructionStates.add(new PickUpLandTransporterMPCIState(others));
        }
        ArrayList<SeaTransporter> dockedBoats = seaTransporterShoreManager.getContentsOfArea(landTransporterManager.getLocation(currentRoadTransporter));
        if(dockedBoats.size() > 0){
            mpcInstructionStates.add(new PickUpSeaTransporterMPCIState(dockedBoats));
        }
        if(mpcInstructionStates.size() == 0){
            mpcInstructionStates.add(new NoMoveMPCIState());
        }
        currentMPCInstructionState = mpcInstructionStates.get(0);
    }

    public void dropOff(Product product){
        cargoManager.remove(currentRoadTransporter, product);
        product.dropOff(landTransporterManager.getLocation(currentRoadTransporter));
    }
    public void pickUpResource(Resource r){
        resourceManager.remove(landTransporterManager.getLocation(currentRoadTransporter), r);
        cargoManager.add(currentRoadTransporter, r);
    }

    public void pickUpLandTransporter(LandTransporter lt){
        landTransporterManager.removeOccupant(lt);
        cargoManager.add(currentRoadTransporter, lt);
        roadTransporters.remove(lt);
    }
    public void pickUpSeaTransporter(SeaTransporter st){
        seaTransporterShoreManager.removeOccupant(st);
        cargoManager.add(currentRoadTransporter, st);
    }

    @Override
    public void notifyObservers(Vector<MovePhaseControlObserver> movePhaseControlObservers) {
        for(MovePhaseControlObserver observer : movePhaseControlObservers){
            observer.updateModeToRoadTransporter();
        }
    }


    public void select() {

        currentMPCInstructionState.select(this);

    }

    public void nextInstruction() {
        int next = (mpcInstructionStates.indexOf(currentMPCInstructionState)+1)
                % mpcInstructionStates.size();
        currentMPCInstructionState = mpcInstructionStates.get(next);
    }

    public void previousInstruction() {
        int previous = (mpcInstructionStates.indexOf(currentMPCInstructionState)-1
                + mpcInstructionStates.size()) % mpcInstructionStates.size();
        currentMPCInstructionState = mpcInstructionStates.get(previous);
    }

    public void cycleLeft() {
        currentMPCInstructionState.cycleLeft(this);
    }

    public void cycleRight() {
        currentMPCInstructionState.cycleRight(this);
    }

    public void setStateToMoveSelected() {
        currentMPCInstructionState = new RoadTransporterMoveSelectedState(this);
    }

    public RoadTransporter getCurrentRoadTransporter() {
        return currentRoadTransporter;
    }

    public LandTransporterManager getLandTransporterManager() {
        return landTransporterManager;
    }

    public SectorTransporterManager getSectorTransporterManager() {
        return landTransporterManager;
    }

    public SectorAdjacencyManager getRoadAdjacencyManager() {
        return roadAdjacencyManager;
    }

    public MPCInstructionState getCurrentMPCInstructionState() {
        return currentMPCInstructionState;
    }

    @Override
    public ResourceManager getResourceManager() {
        return resourceManager;
    }

    @Override
    public CargoManager getCargoManager() {
        return cargoManager;
    }

    public void setCurrentMPCInstructionState(MPCInstructionState currentMPCInstructionState) {
        this.currentMPCInstructionState = currentMPCInstructionState;
    }

    public Transporter getCurrentTransporter(){
        return currentRoadTransporter;
    }


    //testing only
    public String toString(){
        return "Road Transporter Mode";
    }
    public int currentIndex(){
        return roadTransporters.indexOf(currentRoadTransporter);
    }
}
