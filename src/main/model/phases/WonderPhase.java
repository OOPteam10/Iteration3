package model.phases;

import model.Game;
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
    public void execute(PlayerID p1, PlayerID p2, Game context) {
        execute(p1);
        execute(p2);
        context.startNextPhase();  //TODO: different strategies for this line if the game is over or not
    }

    @Override
    public void execute(PlayerID playerID) {

    }
}
