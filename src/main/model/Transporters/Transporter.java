package model.Transporters;



import model.structures.producers.Product;

import model.Transporters.Visitor.TransporterVisitor;

/**
 * Created by hankerins on 4/8/17.
 */

public abstract class Transporter<L> implements Product<L> {

    public abstract void accept(TransporterVisitor v);
    public abstract void dropOff(L l);

}
