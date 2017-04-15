package controller.MovePhaseControlSubsystem.MPCInstructionSubsystem;

import controller.MovePhaseControlSubsystem.MovePhaseControlMode;
import model.Transporters.LandTransporter;

import java.util.ArrayList;

/**
 * Created by hankerins on 4/13/17.
 */
public class PickUpLandTransporterMPCIState implements MPCInstructionState {

    private ArrayList<LandTransporter> landTransporters;

    public PickUpLandTransporterMPCIState(ArrayList<LandTransporter> landTransporters){
        this.landTransporters = landTransporters;
    }

    public void cycleLeft(MovePhaseControlMode context) {
        context.previousInstruction();
    }

    public void cycleRight(MovePhaseControlMode context) {
        context.nextInstruction();
    }

    public void select(MovePhaseControlMode context) {
        context.setCurrentMPCInstructionState(new PickUpLandTransporterSelectedState(context, landTransporters));
    }

    //testing only
    public String toString(){
        return "Pick Up Land Transporter State";
    }
}
