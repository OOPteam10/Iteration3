package controller.MovePhaseControlSubsystem;

import controller.MovePhaseControlSubsystem.MPCInstructionSubsystem.MPCInstructionState;
import model.Transporters.LandTransporter;

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
    void dropOff();
    void pickUp();
    void pickUpLandTransporter(LandTransporter lt);
    int currentIndex();
    MPCInstructionState getCurrentMPCInstructionState();

}
