package controller.BuildPhaseControlSubsystem;

import model.TileSubsystem.Sector;
import model.Transporters.Transporter;

/**
 * Created by hankerins on 4/16/17.
 */
public interface BPCTransporterStrategy<T extends Transporter> {

    void nextTransporter(BuildPhaseControl context);
    void prevTransporter(BuildPhaseControl context);
    Sector getCurrentSector(BuildPhaseControl context);
}
