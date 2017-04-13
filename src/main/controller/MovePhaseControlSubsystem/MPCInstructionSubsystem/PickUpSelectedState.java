package controller.MovePhaseControlSubsystem.MPCInstructionSubsystem;

import controller.MovePhaseControlSubsystem.LandMovePhaseControlMode;
import controller.MovePhaseControlSubsystem.MovePhaseControlMode;
import model.resources.Resource;

import java.util.ArrayList;

/**
 * Created by hankerins on 4/13/17.
 */
public class PickUpSelectedState implements MPCInstructionState {

    private ArrayList<Resource> resources;
    private Resource currentResource;

    public PickUpSelectedState(LandMovePhaseControlMode context) {
        resources = context.getResourceManager().get(context.getLandTransporterManager().getLocation(context.getCurrentLandTransporter()));
        currentResource = resources.get(0);
    }

    @Override
    public void cycleLeft(MovePhaseControlMode context) {

    }

    @Override
    public void cycleRight(MovePhaseControlMode context) {

    }

    @Override
    public void select(MovePhaseControlMode context) {

    }
}
