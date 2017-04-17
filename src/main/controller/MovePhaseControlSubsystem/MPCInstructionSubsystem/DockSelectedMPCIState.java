package controller.MovePhaseControlSubsystem.MPCInstructionSubsystem;

import controller.MovePhaseControlSubsystem.MovePhaseControlMode;
import controller.MovePhaseControlSubsystem.MovePhaseControlObserver;
import controller.MovePhaseControlSubsystem.SeaTransporterMPCMode;
import model.Managers.SeaTransporterManager;
import model.Managers.SeaTransporterShoreManager;
import model.Managers.WaterwayToSectorManager;
import model.TileSubsystem.Sector;
import model.TileSubsystem.Waterway;
import model.Transporters.SeaTransporter;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by hankerins on 4/15/17.
 */
public class DockSelectedMPCIState implements SeaTransporterMPCIState {

    private ArrayList<Sector> adjacentSectors;
    private Waterway currentWaterway;
    private Sector targetSector;

    private SeaTransporter currentSeaTransporter;
    private SeaTransporterManager seaTransporterManager;
    private SeaTransporterShoreManager seaTransporterShoreManager;
    private WaterwayToSectorManager waterwayToSectorManager;

    public DockSelectedMPCIState(SeaTransporterMPCMode context){
        currentSeaTransporter = context.getCurrentSeaTransporter();
        seaTransporterManager = context.getSeaTransporterManager();
        seaTransporterShoreManager = context.getSeaTransporterShoreManager();
        waterwayToSectorManager = context.getWaterwayToSectorManager();
        currentWaterway = seaTransporterManager.getLocation(currentSeaTransporter);
        adjacentSectors = waterwayToSectorManager.get(currentWaterway);
        targetSector = adjacentSectors.get(0);

    }

    @Override
    public void cycleLeft(SeaTransporterMPCMode context) {
        int previous = (adjacentSectors.indexOf(targetSector)-1 + adjacentSectors.size()) % adjacentSectors.size();
        targetSector = adjacentSectors.get(previous);
    }

    @Override
    public void cycleRight(SeaTransporterMPCMode context) {
        int next = (adjacentSectors.indexOf(targetSector)+1) % adjacentSectors.size();
        targetSector = adjacentSectors.get(next);
    }

    @Override
    public void select(SeaTransporterMPCMode context) {
        seaTransporterManager.removeOccupant(currentSeaTransporter);
        seaTransporterShoreManager.add(currentSeaTransporter, targetSector);
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
        return ("Dock at " + targetSector.toString());
    }
}
