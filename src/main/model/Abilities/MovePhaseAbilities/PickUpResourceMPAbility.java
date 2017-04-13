package model.Abilities.MovePhaseAbilities;

import controller.MovePhaseControlSubsystem.MPCInstructionSubsystem.MPCInstructionState;
import controller.MovePhaseControlSubsystem.MPCInstructionSubsystem.PickUpMPCIState;

/**
 * Created by hankerins on 4/13/17.
 */
public class PickUpResourceMPAbility extends MovePhaseAbility {
    @Override
    MPCInstructionState produceInstructionState() {
        return new PickUpMPCIState();
    }
}
