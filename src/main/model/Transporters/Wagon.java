package model.Transporters;

import model.Transporters.Visitor.RoadTransporterVisitor;

/**
 * Created by Karth on 4/12/2017.
 */
public class Wagon extends RoadTransporter{
    @Override
    public void accept(RoadTransporterVisitor v){
        v.visitWagon(this);
    }
}
