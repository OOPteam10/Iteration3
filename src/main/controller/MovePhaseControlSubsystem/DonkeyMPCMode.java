package controller.MovePhaseControlSubsystem;

import controller.MovePhaseControlSubsystem.MPCInstructionSubsystem.*;
import model.Managers.*;
import model.Transporters.Donkey;
import model.Transporters.LandTransporter;

import model.resources.Resource;
import model.structures.producers.Product;

import java.util.ArrayList;

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
    private SectorAdjacencyManager sectorAdjacencyManager;
    private SectorAdjacencyManager roadAdjacencyManager;
    private ResourceManager resourceManager;
    private CargoManager cargoManager;

    public DonkeyMPCMode(ArrayList<Donkey> donkeys, MovePhaseControl context){
        this.donkeys = donkeys;
        currentDonkey = donkeys.get(0);
        landTransporterManager = context.getLandTransporterManager();
        sectorAdjacencyManager = context.getSectorAdjacencyManager();
        roadAdjacencyManager = context.getRoadAdjacencyManager();
        resourceManager = context.getResourceManager();
        cargoManager = context.getCargoManager();
        resetCurrentMPCInstructionState();
    }

    public void nextTransporter() {
        int next = (donkeys.indexOf(currentDonkey)+1)
                % donkeys.size();
        currentDonkey = donkeys.get(next);
    }

    public void previousTransporter() {
        int previous = (donkeys.indexOf(currentDonkey)-1
                + donkeys.size()) % donkeys.size();
        currentDonkey = donkeys.get(previous);
    }

    public void resetCurrentMPCInstructionState(){
        mpcInstructionStates.clear();
        mpcInstructionStates.add(new MoveMPCIState());
        currentMPCInstructionState = mpcInstructionStates.get(0);
        if(resourceManager.getQuantityInArea(landTransporterManager.getLocation(currentDonkey)) > 0){
            mpcInstructionStates.add(new PickUpMPCIState());
        }
        if(cargoManager.getQuantityInArea(currentDonkey) > 0){
            mpcInstructionStates.add(new DropOffMPCIState());
        }
        ArrayList<LandTransporter> others = landTransporterManager.getNeighbors(currentDonkey);
        if(others.size() > 0){
            mpcInstructionStates.add(new PickUpTransporterMPCIState(others));
        }

    }

    public void dropOff(){
        Product p = cargoManager.pop(currentDonkey);
        p.dropOff(landTransporterManager.getLocation(currentDonkey)); //crashes if donkey is carrying a seaTransporter
        //currently doesn't add the donkey back to the list of donkeys to control
        //this is easily fixed by using a list of donkeys that is updated from the landTransporterManager,
        //but would require rtti to add only the donkeys from the LTM to the list
        //also, if donkeys exist but are all being carried as cargo (ergo, no donkeys in the LTM),
        //we don't want this mode to exist, so we need a way for the LTM to return all its donkeys
        //one option is to have a specific donkey manager separate from LTM, but then we have to check
        //2 managers to find all the transporters a donkey can pick up, 2 lists during production/building phase
        //to know where we can produce/build, etc.  Lets solve this
    };
    public void pickUp(){
        Resource r = resourceManager.pop(landTransporterManager.getLocation(currentDonkey));
        cargoManager.add(currentDonkey, r);
    }

    public void pickUpLandTransporter(LandTransporter lt){
        landTransporterManager.removeOccupant(lt);
        cargoManager.add(currentDonkey, lt);
        donkeys.remove(lt);
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

    public SectorAdjacencyManager getSectorAdjacencyManager() {
        return sectorAdjacencyManager;
    }

    public SectorAdjacencyManager getRoadAdjacencyManager() {
        return roadAdjacencyManager;
    }

    public MPCInstructionState getCurrentMPCInstructionState() {
        return currentMPCInstructionState;
    }

    //testing only
    public String toString(){
        return "Donkey Mode";
    }
    public int currentIndex(){
        return donkeys.indexOf(currentDonkey);
    }

}
