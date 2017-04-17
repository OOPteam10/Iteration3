package controller.MovePhaseControlSubsystem;

import model.TileSubsystem.Sector;
import model.TileSubsystem.Terrains.Sea;
import model.TileSubsystem.Waterway;
import model.Transporters.*;
import model.resources.Resource;
import model.structures.producers.Product;

/**
 * Created by rishabh on 16/04/17.
 */
public interface MovePhaseControlObserver {

    //modes
    public void updateModeToDonkey();
    public void updateModeToRoadTransporter();
    public void updateModeToSeaTransporter();

    //highlighters
    public void highlightCurrentDonkey(Donkey donkey);
    public void highlightCurrentRoadTransporter(RoadTransporter roadTransporter);
    public void highlightCurrentSeaTransporter(SeaTransporter seaTransporter);
    void highlightCurrentProduct(Product currentProduct);
    void highlightCurrentLandTransporter(LandTransporter currentTransporter);

    public void highlightCurrentResource(Resource resource);


    //departSelectedState, seaTransporterMove
    public void highlightCurrentWaterway(Waterway waterway);

    //for dockSelectedState, Land and Road TransporterMove
    public void highlightCurrentSector(Sector sector);

    public void highlightNoMove();
    //instructions
    public void updateSeaInstructionToDepart();
    public void updateSeaInstructionToDock();
    public void updateInstructionToMove();
    public void updateInstructionToDropOff();
    public void updateInstructionToPickUpLandTransporter();
    public void updateInstructionToPickUpSeaTransporter();
    public void updateInstructionToPickUpResource();


    void updateInstructionToWaterwayDropOff();
}
