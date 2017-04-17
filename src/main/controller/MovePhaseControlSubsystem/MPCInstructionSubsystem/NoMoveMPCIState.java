package controller.MovePhaseControlSubsystem.MPCInstructionSubsystem;

import controller.MovePhaseControlSubsystem.MovePhaseControlMode;
import controller.MovePhaseControlSubsystem.MovePhaseControlObserver;

import java.util.Vector;

/**
 * Created by hankerins on 4/14/17.
 */
public class NoMoveMPCIState implements MPCInstructionState<MovePhaseControlMode> {
    @Override
    public void cycleLeft(MovePhaseControlMode context) {

    }

    @Override
    public void cycleRight(MovePhaseControlMode context) {

    }

    @Override
    public void select(MovePhaseControlMode context) {

    }
    @Override
    public void notifyObservers(Vector<MovePhaseControlObserver> observers) {
        for(MovePhaseControlObserver observer : observers ){
            observer.highlightNoMove();
        }
    }



    public String toString(){
        return "No Instructions Possible";
    }
}
