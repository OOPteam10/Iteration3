package model.structures.producers.secondary.transportation;

import model.Managers.LandTransporterManager;
import model.Managers.SeaTransporterManager;
import model.Transporters.LandTransporter;
import model.Transporters.SeaTransporter;

/**
 * Created by hankerins on 4/12/17.
 */
public abstract class SeaTransportationProducer extends TransportationProducer {
    public abstract SeaTransporter produce(SeaTransporterManager seaTransporterManager);
}
