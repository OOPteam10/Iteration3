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
        System.out.println("Good Donkey");
    }

    @Override
    public void updateModeToRoadTransporter() {
        System.out.println("Good Donkey");
    }

    @Override
    public void updateModeToSeaTransporter() {
        System.out.println("Good Donkey");
    }

    @Override
    public void highlightCurrentDonkey(Donkey donkey) {
        System.out.println("Good Donkey");
    }

    @Override
    public void highlightCurrentRoadTransporter(RoadTransporter roadTransporter) {
        System.out.println("Good Donkey");
    }

    @Override
    public void highlightCurrentSeaTransporter(SeaTransporter seaTransporter) {
        System.out.println("Good Donkey");
    }

    @Override
    public void highlightCurrentProduct(Product currentProduct) {
        System.out.println("Good Donkey");
    }

    @Override
    public void highlightCurrentLandTransporter(LandTransporter currentTransporter) {
        System.out.println("Good Donkey");
    }

    @Override
    public void highlightCurrentResource(Resource resource) {
        System.out.println("Good Donkey");
    }

    @Override
    public void highlightCurrentWaterway(Waterway waterway) {
        System.out.println("Good Donkey");
    }

    @Override
    public void highlightCurrentSector(Sector sector) {
        System.out.println("Good Donkey");
    }

    @Override
    public void highlightNoMove() {
        System.out.println("Good Donkey");
    }

    @Override
    public void updateSeaInstructionToDepart() {
        System.out.println("Good Donkey");
    }

    @Override
    public void updateSeaInstructionToDock() {
        System.out.println("Good Donkey");
    }

    @Override
    public void updateInstructionToMove() {
        System.out.println("Good Donkey");
    }

    @Override
    public void updateInstructionToDropOff() {
        System.out.println("Good Donkey");
    }

    @Override
    public void updateInstructionToPickUpLandTransporter() {
        System.out.println("Good Donkey");
    }

    @Override
    public void updateInstructionToPickUpSeaTransporter() {

    }

    @Override
    public void updateInstructionToPickUpResource() {

    }

    @Override
    public void updateInstructionToWaterwayDropOff() {
        
    }
}
