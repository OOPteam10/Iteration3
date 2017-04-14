package controller.MovePhaseControlSubsystem.MPCInstructionSubsystem;

import controller.MovePhaseControlSubsystem.MovePhaseControlMode;
import model.Transporters.LandTransporter;
import model.Transporters.Transporter;

import java.util.ArrayList;

/**
 * Created by hankerins on 4/14/17.
 */
public class PickUpLandTransporterSelectedState implements MPCInstructionState {
    private ArrayList<LandTransporter> transporters;
    private LandTransporter currentTransporter;

    public PickUpLandTransporterSelectedState(MovePhaseControlMode context, ArrayList<LandTransporter> transporters) {
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
        context.pickUpLandTransporter(currentTransporter);
        context.resetCurrentMPCInstructionState();
    }

    //testing only
    public String toString(){
        return ("Pick Up " + currentTransporter.toString());
    }
}
