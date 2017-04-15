package controller.MovePhaseControlSubsystem.MPCInstructionSubsystem;

import controller.MovePhaseControlSubsystem.MovePhaseControlMode;

/**
 * Created by hankerins on 4/15/17.
 */
public interface MPCIStateBase<T> {
    void cycleLeft(T context);
    void cycleRight(T context);
    void select(T context);
}
