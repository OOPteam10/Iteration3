package controller.MovePhaseControlSubsystem.MPCInstructionSubsystem;

import controller.MovePhaseControlSubsystem.MovePhaseControlMode;
import controller.MovePhaseControlSubsystem.MovePhaseControlObserver;
import controller.MovePhaseControlSubsystem.RoadTransporterMPCMode;
import model.Managers.LandTransporterManager;
import model.Managers.SectorAdjacencyManager;
import model.TileSubsystem.Sector;
import model.Transporters.RoadTransporter;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by hankerins on 4/14/17.
 */
public class RoadTransporterMoveSelectedState implements MPCInstructionState<MovePhaseControlMode> {
    private ArrayList<Sector> adjacentSectors;
    private Sector currentSector;
    private Sector targetSector;

    private RoadTransporter currentRoadTransporter;
    private LandTransporterManager landTransporterManager;
    private SectorAdjacencyManager roadAdjacencyManager;

    public RoadTransporterMoveSelectedState(RoadTransporterMPCMode context){
        currentRoadTransporter = context.getCurrentRoadTransporter();
        landTransporterManager = context.getLandTransporterManager();
        roadAdjacencyManager = context.getRoadAdjacencyManager();
        currentSector = landTransporterManager.getLocation(currentRoadTransporter);
        adjacentSectors = roadAdjacencyManager.getAdjacencyList(currentSector);
        targetSector = adjacentSectors.get(0);

    }

    @Override
    public void cycleLeft(MovePhaseControlMode context) {
        int previous = (adjacentSectors.indexOf(targetSector)-1 + adjacentSectors.size()) % adjacentSectors.size();
        targetSector = adjacentSectors.get(previous);
    }

    @Override
    public void cycleRight(MovePhaseControlMode context) {
        int next = (adjacentSectors.indexOf(targetSector)+1) % adjacentSectors.size();
        targetSector = adjacentSectors.get(next);
    }

    @Override
    public void select(MovePhaseControlMode context) {
        landTransporterManager.move(currentRoadTransporter, targetSector);
        context.resetCurrentMPCInstructionState();
    }

    @Override
    public void notifyObservers(Vector<MovePhaseControlObserver> observers) {
        for(MovePhaseControlObserver observer : observers ){
            observer.highlightCurrentSector(targetSector);
        }
    }

    //testing only
    public String toString(){
        return ("Road Transporter Move to " + targetSector.toString());
    }
}
