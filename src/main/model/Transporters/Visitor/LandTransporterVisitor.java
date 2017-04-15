package model.Transporters.Visitor;

import model.Transporters.Donkey;
import model.Transporters.Truck;
import model.Transporters.Wagon;

public interface LandTransporterVisitor {
    void visitDonkey(Donkey donkey);
    void visitWagon(Wagon wagon);
    void visitTruck(Truck truck);
}
