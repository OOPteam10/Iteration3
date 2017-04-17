package controller.MovePhaseControlSubsystem.MPCInstructionSubsystem;

import controller.MovePhaseControlSubsystem.SeaTransporterMPCMode;

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

    //testing only
    public String toString(){
        return "Waterway Drop Off State";
    }
}