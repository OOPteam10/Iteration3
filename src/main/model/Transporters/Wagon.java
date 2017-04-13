package model.Transporters;

import model.Transporters.Visitor.LandTransporterVisitor;

/**
 * Created by Karth on 4/13/2017.
 */
public class Wagon extends RoadTransporter {
    @Override
    public void accept(LandTransporterVisitor v){
        v.visitWagon(this);
    }
}
