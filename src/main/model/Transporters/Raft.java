package model.Transporters;


import model.Transporters.Visitor.SeaTransporterVisitor;
import model.structures.producers.Visitor.ProductVisitor;

/**
 * Created by Karth on 4/13/2017.
 */
public class Raft extends SeaTransporter {
    @Override
    public void accept(SeaTransporterVisitor v) {
        v.visitRaft(this);
        //testing
    }

    public String toString() {
        return "Raft";
    }

    @Override
    public void accept(ProductVisitor v) {
        v.visitRaft(this);
    }
}