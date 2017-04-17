package view;

import controller.MovePhaseControlSubsystem.MovePhaseControlObserver;
import model.TileSubsystem.Sector;
import model.TileSubsystem.Waterway;
import model.Transporters.Donkey;
import model.Transporters.LandTransporter;
import model.Transporters.RoadTransporter;
import model.Transporters.SeaTransporter;
import model.resources.Resource;
import model.structures.producers.Product;

/**
 * Created by rishabh on 17/04/17.
 */
public class MovementPhasePreview implements MovePhaseControlObserver {
    @Override
    public void updateModeToDonkey() {

    }

    @Override
    public void updateModeToRoadTransporter() {

    }

    @Override
    public void updateModeToSeaTransporter() {

    }

    @Override
    public void highlightCurrentDonkey(Donkey donkey) {

    }

    @Override
    public void highlightCurrentRoadTransporter(RoadTransporter roadTransporter) {

    }

    @Override
    public void highlightCurrentSeaTransporter(SeaTransporter seaTransporter) {

    }

    @Override
    public void highlightCurrentProduct(Product currentProduct) {

    }

    @Override
    public void highlightCurrentLandTransporter(LandTransporter currentTransporter) {

    }

    @Override
    public void highlightCurrentResource(Resource resource) {

    }

    @Override
    public void highlightCurrentWaterway(Waterway waterway) {

    }

    @Override
    public void highlightCurrentSector(Sector sector) {

    }

    @Override
    public void highlightNoMove() {

    }

    @Override
    public void updateSeaInstructionToDepart() {

    }

    @Override
    public void updateSeaInstructionToDock() {

    }

    @Override
    public void updateInstructionToMove() {

    }

    @Override
    public void updateInstructionToDropOff() {

    }

    @Override
    public void updateInstructionToPickUpLandTransporter() {

    }

    @Override
    public void updateInstructionToPickUpSeaTransporter() {

    }

    @Override
    public void updateInstructionToPickUpResource() {

    }
}
