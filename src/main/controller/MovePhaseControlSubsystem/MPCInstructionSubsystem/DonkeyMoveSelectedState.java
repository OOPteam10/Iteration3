package controller.MovePhaseControlSubsystem.MPCInstructionSubsystem;

import controller.MovePhaseControlSubsystem.DonkeyMPCMode;
import controller.MovePhaseControlSubsystem.MovePhaseControl;
import controller.MovePhaseControlSubsystem.MovePhaseControlMode;
import model.Managers.Adjacency;
import model.Managers.LandTransporterManager;
import model.Managers.SectorAdjacencyManager;
import model.MapSubsystem.Location;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.Sector;
import model.Transporters.Donkey;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by hankerins on 4/11/17.
 */
public class DonkeyMoveSelectedState implements MPCInstructionState {

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

    //testing only
    public String toString(){
        return ("Donkey Move to " + targetSector.toString());
    }
}
