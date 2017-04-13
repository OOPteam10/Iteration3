package model.Transporters;

import model.Transporters.Visitor.LandTransporterVisitor;

/**
 * Created by Karth on 4/12/2017.
 */
public class Wagon extends LandTransporter{
    @Override
    public void accept(LandTransporterVisitor v){
        v.visitWagon(this);
    }
}
