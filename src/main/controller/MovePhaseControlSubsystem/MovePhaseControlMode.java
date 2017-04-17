package controller.MovePhaseControlSubsystem;

import controller.MovePhaseControlSubsystem.MPCInstructionSubsystem.MPCInstructionState;
import model.Managers.CargoManager;
import model.Managers.ResourceManager;
import model.Managers.SectorTransporterManager;
import model.Transporters.LandTransporter;
import model.Transporters.SeaTransporter;
import model.Transporters.Transporter;
import model.resources.Resource;
import model.structures.producers.Product;

import java.util.Vector;

/**
 * Created by hankerins on 4/10/17.
 */
public interface MovePhaseControlMode {
    void nextTransporter(Vector<MovePhaseControlObserver> observers);
    void previousTransporter(Vector<MovePhaseControlObserver> observers);
    void select();
    void nextInstruction();
    void previousInstruction();
    void cycleLeft();
    void cycleRight();
    void setStateToMoveSelected();
    void resetCurrentMPCInstructionState();
    void dropOff(Product product);
    void pickUpResource(Resource r);
    void pickUpLandTransporter(LandTransporter lt);
    int currentIndex();
    MPCInstructionState getCurrentMPCInstructionState();
    void setCurrentMPCInstructionState(MPCInstructionState currentMPCInstructionState);
    ResourceManager getResourceManager();
    CargoManager getCargoManager();
    SectorTransporterManager getSectorTransporterManager();
    Transporter getCurrentTransporter();
    void pickUpSeaTransporter(SeaTransporter st);
    void notifyObservers(Vector<MovePhaseControlObserver> observers);

}
