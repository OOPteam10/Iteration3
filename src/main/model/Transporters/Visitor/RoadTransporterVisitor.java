package model.Transporters.Visitor;

import model.Transporters.Truck;
import model.Transporters.Wagon;

/**
 * Created by Karth on 4/12/2017.
 */
public interface RoadTransporterVisitor {
    void visitWagon(Wagon wagon);
    void visitTruck(Truck truck);
}
