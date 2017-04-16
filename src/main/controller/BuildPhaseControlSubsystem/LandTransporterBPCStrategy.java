package controller.BuildPhaseControlSubsystem;

import model.TileSubsystem.Sector;
import model.Transporters.LandTransporter;

/**
 * Created by hankerins on 4/16/17.
 */
public class LandTransporterBPCStrategy implements BPCTransporterStrategy<LandTransporter> {
    @Override
    public void nextTransporter(BuildPhaseControl context) {
        int next = (context.getCurrentTransporterIndex()+1);
        if(next >= context.getLandTransporters().size()){
            context.setCurrentTransporterIndex(0);
            context.setBuildPhaseControlStrategy(new SeaTransporterBPCStrategy());
        }
        else{
            context.setCurrentTransporterIndex(next);
        }
    }

    @Override
    public void prevTransporter(BuildPhaseControl context) {
        int prev = (context.getCurrentTransporterIndex()-1);
        if(prev < 0){
            context.setCurrentTransporterIndex(context.getSeaTransporters().size()-1);
            context.setBuildPhaseControlStrategy(new SeaTransporterBPCStrategy());
        }
        else{
            context.setCurrentTransporterIndex(prev);
        }
    }

    @Override
    public Sector getCurrentSector(BuildPhaseControl context) {
        return context.getLandTransporterManager().getLocation(context.getLandTransporters().get(context.getCurrentTransporterIndex()));
    }
}
