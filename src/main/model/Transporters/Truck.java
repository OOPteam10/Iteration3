package model.Transporters;

import model.Transporters.Visitor.LandTransporterVisitor;

/**
 * Created by Karth on 4/12/2017.
 */
public class Truck extends LandTransporter {
    @Override
    public void accept(LandTransporterVisitor v){
        v.visitTruck(this);
    }
}
