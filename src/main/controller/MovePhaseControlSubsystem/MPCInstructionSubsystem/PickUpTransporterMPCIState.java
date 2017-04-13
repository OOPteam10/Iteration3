package controller.MovePhaseControlSubsystem.MPCInstructionSubsystem;

import controller.MovePhaseControlSubsystem.MovePhaseControlMode;
import model.Transporters.LandTransporter;

import java.util.ArrayList;

/**
 * Created by hankerins on 4/13/17.
 */
public class PickUpTransporterMPCIState implements MPCInstructionState {

    private ArrayList<LandTransporter> landTransporters;

    public PickUpTransporterMPCIState(ArrayList<LandTransporter> landTransporters){
        this.landTransporters = landTransporters;
    }

    public void cycleLeft(MovePhaseControlMode context) {
        context.previousInstruction();
    }

    public void cycleRight(MovePhaseControlMode context) {
        context.nextInstruction();
    }

    public void select(MovePhaseControlMode context) {
        //TODO: actually select what to pick up
        context.pickUpLandTransporter(landTransporters.get(0));
        context.resetCurrentMPCInstructionState();
    }

    //testing only
    public String toString(){
        return "Pick Up Transporter State";
    }
}
