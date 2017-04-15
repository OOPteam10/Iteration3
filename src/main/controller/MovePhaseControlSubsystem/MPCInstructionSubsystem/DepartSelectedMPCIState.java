package controller.MovePhaseControlSubsystem.MPCInstructionSubsystem;

import controller.MovePhaseControlSubsystem.SeaTransporterMPCMode;
import model.Managers.SeaTransporterManager;
import model.Managers.SeaTransporterShoreManager;
import model.Managers.SectorToWaterwayManager;
import model.TileSubsystem.Sector;
import model.TileSubsystem.Waterway;
import model.Transporters.SeaTransporter;

import java.util.ArrayList;

/**
 * Created by hankerins on 4/15/17.
 */
public class DepartSelectedMPCIState implements SeaTransporterMPCIState {
    private ArrayList<Waterway> adjacentWaterways;
    private Sector currentSector;
    private Waterway targetWaterway;

    private SeaTransporter currentSeaTransporter;
    private SeaTransporterManager seaTransporterManager;
    private SeaTransporterShoreManager seaTransporterShoreManager;
    private SectorToWaterwayManager sectorToWaterwayManager;

    public DepartSelectedMPCIState(SeaTransporterMPCMode context){
        currentSeaTransporter = context.getCurrentSeaTransporter();
        seaTransporterManager = context.getSeaTransporterManager();
        seaTransporterShoreManager = context.getSeaTransporterShoreManager();
        sectorToWaterwayManager = context.getSectorToWaterwayManager();
        currentSector = seaTransporterShoreManager.getLocation(currentSeaTransporter);
        adjacentWaterways = sectorToWaterwayManager.get(currentSector);
        targetWaterway = adjacentWaterways.get(0);

    }

    @Override
    public void cycleLeft(SeaTransporterMPCMode context) {
        int previous = (adjacentWaterways.indexOf(targetWaterway)-1 + adjacentWaterways.size()) % adjacentWaterways.size();
        targetWaterway = adjacentWaterways.get(previous);
    }

    @Override
    public void cycleRight(SeaTransporterMPCMode context) {
        int next = (adjacentWaterways.indexOf(targetWaterway)+1) % adjacentWaterways.size();
        targetWaterway = adjacentWaterways.get(next);
    }

    @Override
    public void select(SeaTransporterMPCMode context) {
        seaTransporterShoreManager.removeOccupant(currentSeaTransporter);
        seaTransporterManager.add(currentSeaTransporter, targetWaterway);
        context.resetCurrentMPCInstructionState();
    }

    //testing only
    public String toString(){
        return ("Depart to " + targetWaterway.toString());
    }
}
