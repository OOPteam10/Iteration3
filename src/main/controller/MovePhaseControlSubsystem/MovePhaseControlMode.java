package controller.MovePhaseControlSubsystem;

import controller.MovePhaseControlSubsystem.MPCInstructionSubsystem.MPCInstructionState;
import model.Managers.CargoManager;
import model.Managers.LandTransporterManager;
import model.Managers.ResourceManager;
import model.Managers.TransporterManager;
import model.Transporters.LandTransporter;
import model.Transporters.Transporter;
import model.structures.producers.Product;

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
    void dropOff(Product product);
    void pickUp();
    void pickUpLandTransporter(LandTransporter lt);
    int currentIndex();
    MPCInstructionState getCurrentMPCInstructionState();
    void setCurrentMPCInstructionState(MPCInstructionState currentMPCInstructionState);
    ResourceManager getResourceManager();
    CargoManager getCargoManager();
    LandTransporterManager getLandTransporterManager();
    Transporter getCurrentTransporter();

}
