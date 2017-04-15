package controller.MovePhaseControlSubsystem.MPCInstructionSubsystem;

import controller.MovePhaseControlSubsystem.MovePhaseControlMode;

/**
 * Created by hankerins on 4/11/17.
 */
public class PickUpResourceMPCIState implements MPCInstructionState {

    public void cycleLeft(MovePhaseControlMode context) {
        context.previousInstruction();
    }

    public void cycleRight(MovePhaseControlMode context) {
        context.nextInstruction();
    }

    public void select(MovePhaseControlMode context) {
        context.setCurrentMPCInstructionState(new PickUpResourceSelectedState(context));

    }
    //testing only
    public String toString(){
        return "Pick Up Resource State";
    }
}
