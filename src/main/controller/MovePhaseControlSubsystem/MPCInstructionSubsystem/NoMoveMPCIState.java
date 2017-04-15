package controller.MovePhaseControlSubsystem.MPCInstructionSubsystem;

import controller.MovePhaseControlSubsystem.MovePhaseControlMode;

/**
 * Created by hankerins on 4/14/17.
 */
public class NoMoveMPCIState implements MPCInstructionState {
    @Override
    public void cycleLeft(MovePhaseControlMode context) {

    }

    @Override
    public void cycleRight(MovePhaseControlMode context) {

    }

    @Override
    public void select(MovePhaseControlMode context) {

    }

    public String toString(){
        return "No Instructions Possible";
    }
}
