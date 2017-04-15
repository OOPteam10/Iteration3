package controller.MovePhaseControlSubsystem.MPCInstructionSubsystem;

import controller.MovePhaseControlSubsystem.MovePhaseControlMode;
import controller.MovePhaseControlSubsystem.RoadTransporterMPCMode;
import controller.MovePhaseControlSubsystem.SeaTransporterMPCMode;
import model.Managers.SeaTransporterManager;
import model.Managers.WaterwayAdjacencyManager;
import model.TileSubsystem.Waterway;
import model.Transporters.SeaTransporter;

import java.util.ArrayList;

/**
 * Created by hankerins on 4/15/17.
 */
public class SeaTransporterMoveSelectedState implements MPCInstructionState {
    private ArrayList<Waterway> adjacentWaterways;
    private Waterway currentWaterway;
    private Waterway targetWaterway;

    private SeaTransporter currentSeaTransporter;
    private SeaTransporterManager seaTransporterManager;
    private WaterwayAdjacencyManager waterwayAdjacencyManager;

    public SeaTransporterMoveSelectedState(SeaTransporterMPCMode context){
        currentSeaTransporter = context.getCurrentSeaTransporter();
        seaTransporterManager = context.getSeaTransporterManager();
        waterwayAdjacencyManager = context.getWaterwayAdjacencyManager();
        currentWaterway = seaTransporterManager.getLocation(currentSeaTransporter);
        adjacentWaterways = waterwayAdjacencyManager.getAdjacencyList(currentWaterway);
        targetWaterway = adjacentWaterways.get(0);

    }

    @Override
    public void cycleLeft(MovePhaseControlMode context) {
        int previous = (adjacentWaterways.indexOf(targetWaterway)-1 + adjacentWaterways.size()) % adjacentWaterways.size();
        targetWaterway = adjacentWaterways.get(previous);
    }

    @Override
    public void cycleRight(MovePhaseControlMode context) {
        int next = (adjacentWaterways.indexOf(targetWaterway)+1) % adjacentWaterways.size();
        targetWaterway = adjacentWaterways.get(next);
    }

    @Override
    public void select(MovePhaseControlMode context) {
        seaTransporterManager.move(currentSeaTransporter, targetWaterway);
        context.resetCurrentMPCInstructionState();
    }

    //testing only
    public String toString(){
        return ("Sea Transporter Move to " + targetWaterway.toString());
    }
}
