package model.Transporters;

import model.Managers.LandTransporterManager;
import model.Transporters.Visitor.RoadTransporterVisitor;

/**
 * Created by hankerins on 4/8/17.
 */
public abstract class RoadTransporter extends Transporter{
    public abstract void accept(RoadTransporterVisitor v);
}
