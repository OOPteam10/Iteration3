package model.Transporters;

import model.Transporters.Visitor.LandTransporterVisitor;
import model.Transporters.Visitor.RoadTransporterVisitor;

/**
 * Created by Karth on 4/12/2017.
 */
public class Truck extends RoadTransporter {
    @Override
    public void accept(RoadTransporterVisitor v){
        v.visitTruck(this);
    }
}
