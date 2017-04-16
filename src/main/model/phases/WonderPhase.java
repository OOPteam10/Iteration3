package model.phases;

import model.Managers.CargoManager;
import model.Managers.LandTransporterManager;
import model.Managers.ResourceManager;
import model.Managers.SeaTransporterShoreManager;
import model.PlayerID;

/**
 * Created by cduica on 4/15/17.
 */
public class WonderPhase implements Phase{

    private LandTransporterManager landTransporterManager;
    private ResourceManager resourceManager;
    private SeaTransporterShoreManager seaTransporterShoreManager;
    private CargoManager cargoManager;

    public WonderPhase(LandTransporterManager landTransporterManager,
                       ResourceManager resourceManager,
                       SeaTransporterShoreManager seaTransporterShoreManager,
                       CargoManager cargoManager) {
        this.landTransporterManager = landTransporterManager;
        this.resourceManager = resourceManager;
        this.seaTransporterShoreManager = seaTransporterShoreManager;
        this.cargoManager = cargoManager;
    }

    @Override
    public void execute(PlayerID p1, PlayerID p2) {

    }
}
