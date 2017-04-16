package model.Transporters.Visitor;

import model.Managers.CargoManager;
import model.Transporters.Donkey;
import model.Transporters.Truck;
import model.Transporters.Wagon;
import utilities.FileManager.FileInfoFactory;
import utilities.FileManager.FileInfoVisitor;

/**
 * Created by Doug on 4/15/2017.
 */
public class LandTransporterFileVisitor extends FileInfoVisitor implements LandTransporterVisitor {
    private CargoManager cargoManager;

    public LandTransporterFileVisitor(CargoManager c) {
        this.cargoManager = c;
    }

    @Override
    public void visitDonkey(Donkey donkey) {
        this.fileInfo = FileInfoFactory.generateFileInfo(donkey, cargoManager);
    }

    @Override
    public void visitWagon(Wagon wagon) {
        this.fileInfo = FileInfoFactory.generateFileInfo(wagon, cargoManager);
    }

    @Override
    public void visitTruck(Truck truck) {
        this.fileInfo = FileInfoFactory.generateFileInfo(truck, cargoManager);
    }
}
