package controller.MovePhaseControlSubsystem;

import controller.MovePhaseControlSubsystem.MPCInstructionSubsystem.MPCInstructionState;
import model.Managers.*;
import model.Transporters.LandTransporter;
import model.Transporters.Transporter;
import model.resources.Resource;
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
    void pickUp(Resource r);
    void pickUpLandTransporter(LandTransporter lt);
    int currentIndex();
    MPCInstructionState getCurrentMPCInstructionState();
    void setCurrentMPCInstructionState(MPCInstructionState currentMPCInstructionState);
    ResourceManager getResourceManager();
    CargoManager getCargoManager();
    SectorTransporterManager getSectorTransporterManager();
    Transporter getCurrentTransporter();

}
