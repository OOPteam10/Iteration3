package controller.MovePhaseControlSubsystem.MPCInstructionSubsystem;

import controller.MovePhaseControlSubsystem.MovePhaseControlMode;

/**
 * Created by hankerins on 4/10/17.
 */
public interface MPCInstructionState<T extends MovePhaseControlMode>{

    void cycleLeft(T context);
    void cycleRight(T context);
    void select(T context);

}
