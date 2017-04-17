package controller.MovePhaseControlSubsystem.MPCInstructionSubsystem;

import controller.MovePhaseControlSubsystem.MovePhaseControlMode;
import controller.MovePhaseControlSubsystem.MovePhaseControlObserver;

import java.util.Vector;

/**
 * Created by hankerins on 4/11/17.
 */
public class DropOffMPCIState implements MPCInstructionState<MovePhaseControlMode> {

    public void cycleLeft(MovePhaseControlMode context) {
        context.previousInstruction();
    }

    public void cycleRight(MovePhaseControlMode context) {
        context.nextInstruction();
    }

    public void select(MovePhaseControlMode context) {
        context.setCurrentMPCInstructionState(new DropOffSelectedState(context));
    }

    @Override
    public void notifyObservers(Vector<MovePhaseControlObserver> observers) {
        for(MovePhaseControlObserver observer : observers ){
            observer.updateInstructionToDropOff();
        }
    }


    //testing only
    public String toString(){
        return "Drop Off State";
    }
}
