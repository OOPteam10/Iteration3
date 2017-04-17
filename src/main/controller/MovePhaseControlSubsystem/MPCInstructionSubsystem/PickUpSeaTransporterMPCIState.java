package controller.MovePhaseControlSubsystem.MPCInstructionSubsystem;

import controller.MovePhaseControlSubsystem.MovePhaseControlMode;
import controller.MovePhaseControlSubsystem.MovePhaseControlObserver;
import model.Transporters.SeaTransporter;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by hankerins on 4/14/17.
 */
public class PickUpSeaTransporterMPCIState implements MPCInstructionState<MovePhaseControlMode> {

    private ArrayList<SeaTransporter> seaTransporters;

    public PickUpSeaTransporterMPCIState(ArrayList<SeaTransporter> seaTransporters){
        this.seaTransporters = seaTransporters;
    }

    public void cycleLeft(MovePhaseControlMode context) {
        context.previousInstruction();
    }

    public void cycleRight(MovePhaseControlMode context) {
        context.nextInstruction();
    }

    public void select(MovePhaseControlMode context) {
        context.setCurrentMPCInstructionState(new PickUpSeaTransporterSelectedState(context, seaTransporters));
    }

    @Override
    public void notifyObservers(Vector<MovePhaseControlObserver> observers) {
        for(MovePhaseControlObserver observer : observers ){
            observer.updateInstructionToPickUpSeaTransporter();
        }
    }

    //testing only
    public String toString(){
        return "Pick Up Sea Transporter State";
    }
}
