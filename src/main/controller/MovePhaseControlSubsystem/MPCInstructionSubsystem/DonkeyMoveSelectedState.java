package controller.MovePhaseControlSubsystem.MPCInstructionSubsystem;

import controller.MovePhaseControlSubsystem.DonkeyMPCMode;
import controller.MovePhaseControlSubsystem.MovePhaseControlMode;
import controller.MovePhaseControlSubsystem.MovePhaseControlObserver;
import model.Managers.Adjacency;
import model.Managers.LandTransporterManager;
import model.Managers.SectorAdjacency;
import model.Managers.SectorAdjacencyManager;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.Sector;
import model.Transporters.Donkey;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by hankerins on 4/11/17.
 */
public class DonkeyMoveSelectedState implements MPCInstructionState<MovePhaseControlMode> {

    private ArrayList<Sector> adjacentSectors;
    private Sector currentSector;
    private Sector targetSector;

    private Donkey currentDonkey;
    private LandTransporterManager landTransporterManager;
    private SectorAdjacencyManager sectorAdjacencyManager;
    private SectorAdjacencyManager roadAdjacencyManager;

    public DonkeyMoveSelectedState(DonkeyMPCMode context){
        currentDonkey = context.getCurrentDonkey();
        landTransporterManager = context.getLandTransporterManager();
        sectorAdjacencyManager = context.getSectorAdjacencyManager();
        roadAdjacencyManager = context.getRoadAdjacencyManager();
        currentSector = landTransporterManager.getLocation(currentDonkey);
        adjacentSectors = sectorAdjacencyManager.getAdjacencyList(currentSector);
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
        landTransporterManager.move(currentDonkey, targetSector);
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
        return ("Donkey Move to " + targetSector.toString());
    }
}
