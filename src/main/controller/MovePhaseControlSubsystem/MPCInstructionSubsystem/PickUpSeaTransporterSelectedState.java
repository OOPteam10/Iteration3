package controller.MovePhaseControlSubsystem.MPCInstructionSubsystem;

import controller.MovePhaseControlSubsystem.MovePhaseControlMode;
import model.Transporters.SeaTransporter;

import java.util.ArrayList;

/**
 * Created by hankerins on 4/14/17.
 */
public class PickUpSeaTransporterSelectedState implements MPCInstructionState {
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

    //testing only
    public String toString(){
        return ("Pick Up " + currentTransporter.toString());
    }
}
