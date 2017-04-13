package model.Transporters;

import model.Transporters.Visitor.SeaTransporterVisitor;

/**
 * Created by Karth on 4/13/2017.
 */
public class Rowboat extends SeaTransporter {
    @Override
    public void accept(SeaTransporterVisitor v){
        v.visitRowboat(this);
    }
}
