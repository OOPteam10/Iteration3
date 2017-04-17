package controller.MovePhaseControlSubsystem.MPCInstructionSubsystem;

import controller.MovePhaseControlSubsystem.MovePhaseControlMode;
import controller.MovePhaseControlSubsystem.MovePhaseControlObserver;
import controller.MovePhaseControlSubsystem.SeaTransporterMPCMode;

import java.util.Vector;

/**
 * Created by hankerins on 4/15/17.
 */
public class DockMPCIState implements SeaTransporterMPCIState {

    public void cycleLeft(SeaTransporterMPCMode context) {
        context.previousInstruction();
    }

    public void cycleRight(SeaTransporterMPCMode context) {
        context.nextInstruction();
    }

    public void select(SeaTransporterMPCMode context) {
        context.setStateToDockSelected();
    }

    @Override
    public void notifyObservers(Vector<MovePhaseControlObserver> observers) {
        for(MovePhaseControlObserver observer : observers ){
            observer.updateSeaInstructionToDock();
        }
    }

    //testing only
    public String toString(){
        return "Dock State";
    }

}
