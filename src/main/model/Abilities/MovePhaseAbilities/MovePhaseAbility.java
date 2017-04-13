package model.Abilities.MovePhaseAbilities;

import controller.MovePhaseControlSubsystem.MPCInstructionSubsystem.MPCInstructionState;

/**
 * Created by hankerins on 4/13/17.
 */
public abstract class MovePhaseAbility {
    abstract MPCInstructionState produceInstructionState();
}
