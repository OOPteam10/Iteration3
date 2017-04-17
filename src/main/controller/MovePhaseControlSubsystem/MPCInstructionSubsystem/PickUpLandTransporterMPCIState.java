package controller.MovePhaseControlSubsystem.MPCInstructionSubsystem;

import controller.MovePhaseControlSubsystem.MovePhaseControlMode;
import controller.MovePhaseControlSubsystem.MovePhaseControlObserver;
import model.Transporters.LandTransporter;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by hankerins on 4/13/17.
 */
public class PickUpLandTransporterMPCIState implements MPCInstructionState<MovePhaseControlMode> {

    private ArrayList<LandTransporter> landTransporters;

    public PickUpLandTransporterMPCIState(ArrayList<LandTransporter> landTransporters){
        this.landTransporters = landTransporters;
    }

    public void cycleLeft(MovePhaseControlMode context) {
        context.previousInstruction();
    }

    public void cycleRight(MovePhaseControlMode context) {
        context.nextInstruction();
    }

    public void select(MovePhaseControlMode context) {
        context.setCurrentMPCInstructionState(new PickUpLandTransporterSelectedState(context, landTransporters));
    }

    @Override
    public void notifyObservers(Vector<MovePhaseControlObserver> observers) {
        for(MovePhaseControlObserver observer : observers ){
            observer.updateInstructionToPickUpLandTransporter();
        }
    }

    //testing only
    public String toString(){
        return "Pick Up Land Transporter State";
    }
}
