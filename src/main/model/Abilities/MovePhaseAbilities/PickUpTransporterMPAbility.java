package model.Abilities.MovePhaseAbilities;

import controller.MovePhaseControlSubsystem.MPCInstructionSubsystem.MPCInstructionState;
import controller.MovePhaseControlSubsystem.MPCInstructionSubsystem.PickUpLandTransporterMPCIState;
import model.Transporters.LandTransporter;

import java.util.ArrayList;

/**
 * Created by hankerins on 4/13/17.
 */
public class PickUpTransporterMPAbility extends MovePhaseAbility {

    private ArrayList<LandTransporter> landTransporters;

    public PickUpTransporterMPAbility(ArrayList<LandTransporter> landTransporters){
        this.landTransporters = landTransporters;
    }

    @Override
    MPCInstructionState produceInstructionState() {
        return new PickUpLandTransporterMPCIState(landTransporters);
    }
}
