package controller.MovePhaseControlSubsystem;

import controller.MovePhaseControlSubsystem.MPCInstructionSubsystem.DonkeyMoveSelectedState;
import controller.MovePhaseControlSubsystem.MPCInstructionSubsystem.MPCInstructionState;
import controller.MovePhaseControlSubsystem.MPCInstructionSubsystem.MoveMPCIState;
import model.Managers.LandTransporterManager;
import model.Managers.SectorAdjacencyManager;
import model.Transporters.Donkey;

import java.util.ArrayList;

/**
 * Created by hankerins on 4/10/17.
 */
public class DonkeyMPCMode implements MovePhaseControlMode {

    private MPCInstructionState currentMPCInstructionState;
    private ArrayList<MPCInstructionState> mpcInstructionStates;
    private Donkey currentDonkey;
    private ArrayList<Donkey> donkeys;
    private LandTransporterManager landTransporterManager;
    private SectorAdjacencyManager sectorAdjacencyManager;
    private SectorAdjacencyManager roadAdjacencyManager;

    public DonkeyMPCMode(ArrayList<Donkey> donkeys, MovePhaseControl context){
        this.donkeys = donkeys;
        currentDonkey = donkeys.get(0);
        landTransporterManager = context.getLandTransporterManager();
        sectorAdjacencyManager = context.getSectorAdjacencyManager();
        roadAdjacencyManager = context.getRoadAdjacencyManager();
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

    public void select() {
        currentMPCInstructionState.select(this);
    }

    public void nextInstruction() {

    }

    public void previousInstruction() {

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

    public void resetCurrentMPCInstructionState() {
        this.currentMPCInstructionState = mpcInstructionStates.get(0);
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
