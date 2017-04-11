package controller.MovePhaseControlSubsystem;

import controller.MovePhaseControlSubsystem.MPCInstructionSubsystem.MPCInstructionState;

/**
 * Created by hankerins on 4/10/17.
 */
public interface MovePhaseControlMode {
    void nextTransporter();
    void previousTransporter();
    void select();
    void nextInstruction();
    void previousInstruction();
    void cycleLeft();
    void cycleRight();
    void setStateToMoveSelected();
    void resetCurrentMPCInstructionState();

}
