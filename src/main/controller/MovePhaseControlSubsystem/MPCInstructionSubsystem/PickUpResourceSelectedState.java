package controller.MovePhaseControlSubsystem.MPCInstructionSubsystem;


import controller.MovePhaseControlSubsystem.MovePhaseControl;
import controller.MovePhaseControlSubsystem.MovePhaseControlMode;
import model.resources.Resource;

import java.util.ArrayList;

/**
 * Created by hankerins on 4/13/17.
 */
public class PickUpResourceSelectedState implements MPCInstructionState {

    private ArrayList<Resource> resources;
    private Resource currentResource;

    public PickUpResourceSelectedState(MovePhaseControlMode context) {
        resources = context.getResourceManager().get(context.getSectorTransporterManager().getLocation(context.getCurrentTransporter()));
        currentResource = resources.get(0);
    }

    @Override
    public void cycleLeft(MovePhaseControlMode context) {
        int previous = (resources.indexOf(currentResource)-1 + resources.size()) % resources.size();
        currentResource = resources.get(previous);
    }

    @Override
    public void cycleRight(MovePhaseControlMode context) {
        int next = (resources.indexOf(currentResource)+1) % resources.size();
        currentResource = resources.get(next);
    }

    @Override
    public void select(MovePhaseControlMode context) {
        context.pickUp(currentResource);
        context.resetCurrentMPCInstructionState();
    }

    //testing only
    public String toString(){
        return ("Pick Up " + currentResource.toString());
    }
}
