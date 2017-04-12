package controller.MovePhaseControlSubsystem;

import controller.MovePhaseControlSubsystem.MPCInstructionSubsystem.*;
import model.Managers.GoodsManager;
import model.Managers.LandTransporterManager;
import model.Managers.SectorAdjacencyManager;
import model.TileSubsystem.Sector;
import model.Transporters.Donkey;
import model.Transporters.Transporter;

import model.resources.Resource;
import model.structures.producers.Product;

import java.util.ArrayList;

/**
 * Created by hankerins on 4/10/17.
 */
public class DonkeyMPCMode implements MovePhaseControlMode {

    private MPCInstructionState currentMPCInstructionState;
    private ArrayList<MPCInstructionState> mpcInstructionStates = new ArrayList<MPCInstructionState>();
    private Donkey currentDonkey;
    private ArrayList<Donkey> donkeys;
    private LandTransporterManager landTransporterManager;
    private SectorAdjacencyManager sectorAdjacencyManager;
    private SectorAdjacencyManager roadAdjacencyManager;
    private GoodsManager<Sector, Resource> landResourceManager;
    private GoodsManager<Transporter, Product> cargoManager;

    public DonkeyMPCMode(ArrayList<Donkey> donkeys, MovePhaseControl context){
        this.donkeys = donkeys;
        currentDonkey = donkeys.get(0);
        landTransporterManager = context.getLandTransporterManager();
        sectorAdjacencyManager = context.getSectorAdjacencyManager();
        roadAdjacencyManager = context.getRoadAdjacencyManager();
        landResourceManager = context.getLandResourceManager();
        cargoManager = context.getCargoManager();
        mpcInstructionStates.add(new MoveMPCIState());
        currentMPCInstructionState = mpcInstructionStates.get(0);
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
        if(landResourceManager.getQuantityInArea(landTransporterManager.getLocation(currentDonkey)) > 0){
            mpcInstructionStates.add(new PickUpMPCIState());
        }
        if(cargoManager.getQuantityInArea(currentDonkey) > 0){
            mpcInstructionStates.add(new DropOffMPCIState());
        }
    }

    public void dropOff(){
        Product p = cargoManager.pop(currentDonkey);
        p.dropOff(landTransporterManager.getLocation(currentDonkey)); //crashes if donkey is carrying a seaTransporter

    };
    public void pickUp(){
        Resource r = landResourceManager.pop(landTransporterManager.getLocation(currentDonkey));
        cargoManager.add(currentDonkey, r);
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
}
