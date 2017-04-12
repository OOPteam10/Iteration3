package controller.MovePhaseControlSubsystem.MPCInstructionSubsystem;

import controller.MovePhaseControlSubsystem.MovePhaseControlMode;

/**
 * Created by hankerins on 4/10/17.
 */
public interface MPCInstructionState {
    void cycleLeft(MovePhaseControlMode context);
    void cycleRight(MovePhaseControlMode context);
    void select(MovePhaseControlMode context);
}
