package controller.BuildPhaseControlSubsystem;

import model.TileSubsystem.Sector;
import model.Transporters.SeaTransporter;

/**
 * Created by hankerins on 4/16/17.
 */
public class SeaTransporterBPCStrategy implements BuildPhaseControlStrategy<SeaTransporter> {
    @Override
    public void nextTransporter(BuildPhaseControl context) {
        int next = (context.getCurrentIndex()+1);
        if(next >= context.getSeaTransporters().size()){
            context.setCurrentIndex(0);
            context.setBuildPhaseControlStrategy(new LandTransporterBPCStrategy());
        }
        else{
            context.setCurrentIndex(next);
        }
    }

    @Override
    public void prevTransporter(BuildPhaseControl context) {
        int prev = (context.getCurrentIndex()-1);
        if(prev < 0){
            context.setCurrentIndex(context.getLandTransporters().size()-1);
            context.setBuildPhaseControlStrategy(new LandTransporterBPCStrategy());
        }
        else{
            context.setCurrentIndex(prev);
        }
    }

    @Override
    public Sector getCurrentSector(BuildPhaseControl context) {
        return context.getSeaTransporterShoreManager().getLocation(context.getSeaTransporters().get(context.getCurrentIndex()));
    }
}
