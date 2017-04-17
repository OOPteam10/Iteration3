package controller.MovePhaseControlSubsystem.MPCInstructionSubsystem;

import controller.MovePhaseControlSubsystem.MovePhaseControlMode;
import controller.MovePhaseControlSubsystem.MovePhaseControlObserver;
import controller.MovePhaseControlSubsystem.SeaTransporterMPCMode;

import java.util.Vector;

/**
 * Created by hankerins on 4/16/17.
 */
public class WaterwayDropOffMPCIState implements SeaTransporterMPCIState {

    public void cycleLeft(SeaTransporterMPCMode context) {
        context.previousInstruction();
    }

    public void cycleRight(SeaTransporterMPCMode context) {
        context.nextInstruction();
    }

    public void select(SeaTransporterMPCMode context) {
        context.setStateToWaterwayDropOffSelected();
    }

    @Override
    public void notifyObservers(Vector<MovePhaseControlObserver> observers) {
        for(MovePhaseControlObserver observer : observers ){
            observer.updateInstructionToWaterwayDropOff();
        }
    }

    //testing only
    public String toString(){
        return "Waterway Drop Off State";
    }
}
