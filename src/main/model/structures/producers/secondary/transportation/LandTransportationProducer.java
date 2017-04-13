package model.structures.producers.secondary.transportation;

import model.Managers.LandTransporterManager;
import model.Managers.TransporterManager;
import model.Transporters.LandTransporter;
import model.Transporters.Transporter;

/**
 * Created by hankerins on 4/12/17.
 */
public abstract class LandTransportationProducer extends TransportationProducer {
    public abstract LandTransporter produce(LandTransporterManager landTransporterManager);
}
