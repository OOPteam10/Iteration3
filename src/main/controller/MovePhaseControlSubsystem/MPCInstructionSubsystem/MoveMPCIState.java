package controller.MovePhaseControlSubsystem.MPCInstructionSubsystem;

import controller.MovePhaseControlSubsystem.MovePhaseControlMode;
import controller.MovePhaseControlSubsystem.MovePhaseControlObserver;

import java.util.Vector;

/**
 * Created by hankerins on 4/10/17.
 */
public class MoveMPCIState implements MPCInstructionState<MovePhaseControlMode> {

    public void cycleLeft(MovePhaseControlMode context) {
        context.previousInstruction();
    }

    public void cycleRight(MovePhaseControlMode context) {
        context.nextInstruction();
    }

    public void select(MovePhaseControlMode context) {
        context.setStateToMoveSelected();
    }


    @Override
    public void notifyObservers(Vector<MovePhaseControlObserver> observers) {
        for(MovePhaseControlObserver observer : observers ){
            observer.updateInstructionToMove();
        }
    }


    //testing only
    public String toString(){
        return "Move State";
    }
}
