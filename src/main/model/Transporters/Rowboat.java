package model.Transporters;

import model.Transporters.Visitor.SeaTransporterVisitor;
import model.structures.producers.Visitor.ProductVisitor;

/**
 * Created by Karth on 4/13/2017.
 */
public class Rowboat extends SeaTransporter {
    @Override
    public void accept(SeaTransporterVisitor v){
        v.visitRowboat(this);
    }

    @Override
    public void accept(ProductVisitor v) {
        v.visitRowboat(this);
    }
}
