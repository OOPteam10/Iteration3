package controller.MovePhaseControlSubsystem.MPCInstructionSubsystem;


import controller.MovePhaseControlSubsystem.MovePhaseControlMode;
import controller.MovePhaseControlSubsystem.MovePhaseControlObserver;
import model.resources.Resource;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by hankerins on 4/13/17.
 */
public class PickUpResourceSelectedState implements MPCInstructionState<MovePhaseControlMode> {

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
        context.pickUpResource(currentResource);
        context.resetCurrentMPCInstructionState();
    }

    @Override
    public void notifyObservers(Vector<MovePhaseControlObserver> observers) {
        for(MovePhaseControlObserver observer : observers ){
            observer.highlightCurrentResource(currentResource);
        }
    }
    //testing only
    public String toString(){
        return ("Pick Up " + currentResource.toString());
    }
}
