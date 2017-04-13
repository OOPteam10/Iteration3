package model.Transporters.Visitor;

import model.Transporters.Donkey;
import model.Transporters.LandTransporter;
import model.Transporters.Truck;
import model.Transporters.Wagon;

/**
 * Created by Karth on 4/12/2017.
 */
public interface LandTransporterVisitor {
    void visitDonkey(Donkey donkey);
}
