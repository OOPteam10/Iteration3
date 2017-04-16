package controller.BuildPhaseControlSubsystem;

import model.TileSubsystem.Sector;
import model.Transporters.SeaTransporter;

/**
 * Created by hankerins on 4/16/17.
 */
public class SeaTransporterBPCStrategy implements BPCTransporterStrategy<SeaTransporter> {
    @Override
    public void nextTransporter(BuildPhaseControl context) {
        int next = (context.getCurrentTransporterIndex()+1);
        if(next >= context.getSeaTransporters().size()){
            context.setCurrentTransporterIndex(0);
            context.setBuildPhaseControlStrategy(new LandTransporterBPCStrategy());
        }
        else{
            context.setCurrentTransporterIndex(next);
        }
    }

    @Override
    public void prevTransporter(BuildPhaseControl context) {
        int prev = (context.getCurrentTransporterIndex()-1);
        if(prev < 0){
            context.setCurrentTransporterIndex(context.getLandTransporters().size()-1);
            context.setBuildPhaseControlStrategy(new LandTransporterBPCStrategy());
        }
        else{
            context.setCurrentTransporterIndex(prev);
        }
    }

    @Override
    public Sector getCurrentSector(BuildPhaseControl context) {
        return context.getSeaTransporterShoreManager().getLocation(context.getSeaTransporters().get(context.getCurrentTransporterIndex()));
    }
}
