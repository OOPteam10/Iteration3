package controller.MovePhaseControlSubsystem;

import controller.MovePhaseControlSubsystem.MPCInstructionSubsystem.*;
import model.Managers.*;
import model.Transporters.Donkey;
import model.Transporters.LandTransporter;
import model.Transporters.SeaTransporter;
import model.Transporters.Transporter;
import model.resources.Resource;
import model.structures.producers.Product;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by hankerins on 4/10/17.
 * TODO: remove donkey from list of available donkeys when its picked up
 */
public class DonkeyMPCMode implements MovePhaseControlMode {

    private MPCInstructionState currentMPCInstructionState;
    private ArrayList<MPCInstructionState> mpcInstructionStates = new ArrayList<MPCInstructionState>();
    private Donkey currentDonkey;
    private ArrayList<Donkey> donkeys;
    private LandTransporterManager landTransporterManager;
    private SeaTransporterShoreManager seaTransporterShoreManager;
    private SectorAdjacencyManager sectorAdjacencyManager;
    private SectorAdjacencyManager roadAdjacencyManager;
    private ResourceManager resourceManager;
    private CargoManager cargoManager;

    public DonkeyMPCMode(ArrayList<Donkey> donkeys, MovePhaseControl context){
        this.donkeys = donkeys;
        currentDonkey = donkeys.get(0);
        landTransporterManager = context.getLandTransporterManager();
        seaTransporterShoreManager = context.getSeaTransporterShoreManager();
        sectorAdjacencyManager = context.getSectorAdjacencyManager();
        roadAdjacencyManager = context.getRoadAdjacencyManager();
        resourceManager = context.getResourceManager();
        cargoManager = context.getCargoManager();
        resetCurrentMPCInstructionState();
    }

    public void nextTransporter(Vector<MovePhaseControlObserver> observers) {
        int next = (donkeys.indexOf(currentDonkey)+1)
                % donkeys.size();
        currentDonkey = donkeys.get(next);
        for(MovePhaseControlObserver observer: observers){
            observer.highlightCurrentDonkey(currentDonkey);
        }
    }

    public void previousTransporter(Vector<MovePhaseControlObserver> observers) {
        int previous = (donkeys.indexOf(currentDonkey)-1
                + donkeys.size()) % donkeys.size();
        currentDonkey = donkeys.get(previous);
        for(MovePhaseControlObserver observer: observers){
            observer.highlightCurrentDonkey(currentDonkey);
        }
    }

    public void resetCurrentMPCInstructionState(){
        mpcInstructionStates.clear();
        if(sectorAdjacencyManager.getAdjacency(landTransporterManager.getLocation(currentDonkey)) != null){
            mpcInstructionStates.add(new MoveMPCIState());
        }

        if(resourceManager.getQuantityInArea(landTransporterManager.getLocation(currentDonkey)) > 0){
            mpcInstructionStates.add(new PickUpResourceMPCIState());
        }
        if(cargoManager.getQuantityInArea(currentDonkey) > 0){
            mpcInstructionStates.add(new DropOffMPCIState());
        }
        ArrayList<LandTransporter> others = landTransporterManager.getNeighbors(currentDonkey);
        if(others.size() > 0){
            mpcInstructionStates.add(new PickUpLandTransporterMPCIState(others));
        }
        ArrayList<SeaTransporter> dockedBoats = seaTransporterShoreManager.getContentsOfArea(landTransporterManager.getLocation(currentDonkey));
        if(dockedBoats.size() > 0){
            mpcInstructionStates.add(new PickUpSeaTransporterMPCIState(dockedBoats));
        }
        if(mpcInstructionStates.size() == 0){
            mpcInstructionStates.add(new NoMoveMPCIState());
        }
        currentMPCInstructionState = mpcInstructionStates.get(0);
    }

    public void dropOff(Product product){
        cargoManager.remove(currentDonkey, product);
        product.dropOff(landTransporterManager.getLocation(currentDonkey));
    }
    public void pickUpResource(Resource r){
        resourceManager.remove(landTransporterManager.getLocation(currentDonkey), r);
        cargoManager.add(currentDonkey, r);
    }

    public void pickUpLandTransporter(LandTransporter lt){
        landTransporterManager.removeOccupant(lt);
        cargoManager.add(currentDonkey, lt);
    }
    public void pickUpSeaTransporter(SeaTransporter st){
        seaTransporterShoreManager.removeOccupant(st);
        cargoManager.add(currentDonkey, st);
    }

    @Override
    public void notifyObservers(Vector<MovePhaseControlObserver> movePhaseControlObservers) {
        for(MovePhaseControlObserver observer : movePhaseControlObservers){
            observer.updateModeToDonkey();
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
        currentMPCInstructionState = new DonkeyMoveSelectedState(this);
    }

    public Donkey getCurrentDonkey() {
        return currentDonkey;
    }

    public LandTransporterManager getLandTransporterManager() {
        return landTransporterManager;
    }

    public SectorTransporterManager getSectorTransporterManager() {
        return landTransporterManager;
    }

    public SectorAdjacencyManager getSectorAdjacencyManager() {
        return sectorAdjacencyManager;
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
        return currentDonkey;
    }


    //testing only
    public String toString(){
        return "Donkey Mode";
    }
    public int currentIndex(){
        return donkeys.indexOf(currentDonkey);
    }

}
