package controller.MovePhaseControlSubsystem.MPCInstructionSubsystem;

import controller.MovePhaseControlSubsystem.MovePhaseControlMode;
import controller.MovePhaseControlSubsystem.MovePhaseControlObserver;
import model.Transporters.SeaTransporter;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by hankerins on 4/14/17.
 */
public class PickUpSeaTransporterSelectedState implements MPCInstructionState<MovePhaseControlMode> {
    private ArrayList<SeaTransporter> transporters;
    private SeaTransporter currentTransporter;

    public PickUpSeaTransporterSelectedState(MovePhaseControlMode context, ArrayList<SeaTransporter> transporters) {
        this.transporters = transporters;
        currentTransporter = transporters.get(0);
    }

    @Override
    public void cycleLeft(MovePhaseControlMode context) {
        int previous = (transporters.indexOf(currentTransporter)-1 + transporters.size()) % transporters.size();
        currentTransporter = transporters.get(previous);
    }

    @Override
    public void cycleRight(MovePhaseControlMode context) {
        int next = (transporters.indexOf(currentTransporter)+1) % transporters.size();
        currentTransporter = transporters.get(next);
    }

    @Override
    public void select(MovePhaseControlMode context) {
        context.pickUpSeaTransporter(currentTransporter);
        context.resetCurrentMPCInstructionState();
    }
    @Override
    public void notifyObservers(Vector<MovePhaseControlObserver> observers) {
        for(MovePhaseControlObserver observer : observers ){
            observer.highlightCurrentSeaTransporter(currentTransporter);
        }
    }

    //testing only
    public String toString(){
        return ("Pick Up " + currentTransporter.toString());
    }
}
