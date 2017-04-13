package controller.MovePhaseControlSubsystem.MPCInstructionSubsystem;

import controller.MovePhaseControlSubsystem.MovePhaseControlMode;

/**
 * Created by hankerins on 4/11/17.
 */
public class PickUpMPCIState implements MPCInstructionState {

    public void cycleLeft(MovePhaseControlMode context) {
        context.previousInstruction();
    }

    public void cycleRight(MovePhaseControlMode context) {
        context.nextInstruction();
    }

    public void select(MovePhaseControlMode context) {
        //TODO: actually select what to pick up
        context.pickUp();
        context.resetCurrentMPCInstructionState();

    }
    //testing only
    public String toString(){
        return "Pick Up Resource State";
    }
}