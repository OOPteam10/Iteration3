package model.Transporters;

//import model.producers.Product;
import model.Transporters.Visitor.TransporterVisitor;

/**
 * Created by hankerins on 4/8/17.
 */
public abstract class Transporter {
    public abstract void accept(TransporterVisitor v);
}
