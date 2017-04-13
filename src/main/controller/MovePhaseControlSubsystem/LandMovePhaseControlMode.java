package controller.MovePhaseControlSubsystem;

import model.Transporters.LandTransporter;

/**
 * Created by hankerins on 4/13/17.
 */
public interface LandMovePhaseControlMode extends MovePhaseControlMode{
    LandTransporter getCurrentLandTransporter();
}
