package controller.BuildPhaseControlSubsystem;

import model.TileSubsystem.Sector;
import model.Transporters.LandTransporter;

/**
 * Created by hankerins on 4/16/17.
 */
public class LandTransporterBPCStrategy implements BuildPhaseControlStrategy<LandTransporter> {
    @Override
    public void nextTransporter(BuildPhaseControl context) {
        int next = (context.getCurrentIndex()+1);
        if(next >= context.getLandTransporters().size()){
            context.setCurrentIndex(0);
            context.setBuildPhaseControlStrategy(new SeaTransporterBPCStrategy());
        }
        else{
            context.setCurrentIndex(next);
        }
    }

    @Override
    public void prevTransporter(BuildPhaseControl context) {
        int prev = (context.getCurrentIndex()-1);
        if(prev < 0){
            context.setCurrentIndex(context.getSeaTransporters().size()-1);
            context.setBuildPhaseControlStrategy(new SeaTransporterBPCStrategy());
        }
        else{
            context.setCurrentIndex(prev);
        }
    }

    @Override
    public Sector getCurrentSector(BuildPhaseControl context) {
        return context.getLandTransporterManager().getLocation(context.getLandTransporters().get(context.getCurrentIndex()));
    }
}
