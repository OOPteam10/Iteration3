package controller;

import controller.Actions.Down;
import controller.Actions.NextMode;
import controller.Actions.PrevMode;
import controller.Actions.Up;
import controller.MovePhaseControlSubsystem.MovePhaseControlMode;
import javafx.scene.input.KeyCode;
import model.Game;
import model.Managers.*;
import model.Transporters.Donkey;
import model.Transporters.RoadTransporter;
import model.Transporters.SeaTransporter;

import java.util.ArrayList;

/**
 * Created by Kevin on 4/16/17.
 */

public class WonderPhaseControl extends ControlHandler{

    MovePhaseControlMode currentMovePhaseControlMode;
    private LandTransporterManager landTransporterManager;
    private SeaTransporterShoreManager seaTransporterShoreManager;
    private ResourceManager resourceManager;
    private CargoManager cargoManager;
    private ArrayList<RoadTransporter> roadTransporterList = new ArrayList<RoadTransporter>();
    private ArrayList<SeaTransporter> seaTransporterList = new ArrayList<SeaTransporter>();

    public WonderPhaseControl(Controller controller, Game game){
        super(controller,game);

        this.landTransporterManager = game.getLandTransporterManager();
        this.seaTransporterShoreManager = game.getSeaTransporterShoreManager();
        this.resourceManager = game.getResourceManager();
        this.cargoManager = game.getCargoManager();

        addAction(new Up(this), new KeyListener(KeyCode.UP));
        addAction(new Down(this), new KeyListener(KeyCode.DOWN));

    }

    @Override
    public void left() {

    }

    @Override
    public void right() {

    }

    @Override
    public void select() {

    }

    @Override
    public void nextMode() {

    }

    @Override
    public void prevMode() {

    }

    @Override
    public void up() {

    }

    @Override
    public void down() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void reset() {

    }

    @Override
    public void centerGravity() {

    }

    @Override
    public void endTurn() {

    }
}
