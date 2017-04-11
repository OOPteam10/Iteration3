package model.Transporters;

import model.Transporters.Visitor.TransporterVisitor;

/**
 * Created by hankerins on 4/8/17.
 */
public abstract class LandTransporter extends Transporter {

    @Override
    public void accept(TransporterVisitor v){
        v.visitLandTransporter(this);
    }
}
