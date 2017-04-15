package controller.MovePhaseControlSubsystem.MPCInstructionSubsystem;

import controller.MovePhaseControlSubsystem.MovePhaseControlMode;
import model.Transporters.SeaTransporter;

import java.util.ArrayList;

/**
 * Created by hankerins on 4/14/17.
 */
public class PickUpSeaTransporterMPCIState implements MPCInstructionState {

    private ArrayList<SeaTransporter> seaTransporters;

    public PickUpSeaTransporterMPCIState(ArrayList<SeaTransporter> seaTransporters){
        this.seaTransporters = seaTransporters;
    }

    public void cycleLeft(MovePhaseControlMode context) {
        context.previousInstruction();
    }

    public void cycleRight(MovePhaseControlMode context) {
        context.nextInstruction();
    }

    public void select(MovePhaseControlMode context) {
        context.setCurrentMPCInstructionState(new PickUpSeaTransporterSelectedState(context, seaTransporters));
    }

    //testing only
    public String toString(){
        return "Pick Up Sea Transporter State";
    }
}
