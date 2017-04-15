package model.Transporters;

import model.Transporters.Visitor.SeaTransporterVisitor;
import model.structures.producers.Visitor.ProductVisitor;

/**
 * Created by Karth on 4/12/2017.
 */
public class Steamship extends SeaTransporter {
    @Override
    public void accept(SeaTransporterVisitor v){
        v.visitSteamship(this);
    }

    @Override
    public void accept(ProductVisitor v) {
        v.visitSteamship(this);
    }
}
