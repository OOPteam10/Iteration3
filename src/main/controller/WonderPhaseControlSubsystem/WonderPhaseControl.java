package controller.WonderPhaseControlSubsystem;

import controller.Actions.Down;
import controller.Actions.Up;
import controller.BuildPhaseControlSubsystem.BuildPhaseControl;
import controller.ControlHandler;
import controller.Controller;
import controller.KeyListener;
import controller.MovePhaseControlSubsystem.MovePhaseControl;
import javafx.scene.input.KeyCode;
import model.Game;
import model.Managers.*;
import model.PlayerID;
import model.Transporters.RoadTransporter;
import model.Transporters.SeaTransporter;
import model.Wonder.Wonder;
import model.phases.ProductionPhase;

import java.util.ArrayList;

/**
 * Created by Kevin on 4/16/17.
 */

public class WonderPhaseControl extends ControlHandler {

    private LandTransporterManager landTransporterManager;
    private SeaTransporterShoreManager seaTransporterShoreManager;
    private ResourceManager resourceManager;
    private CargoManager cargoManager;
    private ArrayList<RoadTransporter> roadTransporterList = new ArrayList<RoadTransporter>();
    private ArrayList<SeaTransporter> seaTransporterList = new ArrayList<SeaTransporter>();
    private int brickNumber;
    private Wonder wonder;
    private PlayerID player1;
    private PlayerID player2;

    public WonderPhaseControl(Controller controller, Game game){
        super(controller,game);

        this.landTransporterManager = game.getLandTransporterManager();
        this.resourceManager = game.getResourceManager();
        this.cargoManager = game.getCargoManager();
        brickNumber = 0;
        wonder = game.getWonder();
        player1 = game.getPlayer1();
        player2 = game.getPlayer2();

        addAction(new Up(this), new KeyListener(KeyCode.UP));
        addAction(new Down(this), new KeyListener(KeyCode.DOWN));
    }

    private void cycleNumUp(){

        brickNumber = (brickNumber + 1) % 10;
    }

    private void cycleNumDown(){

        brickNumber = (brickNumber - 1) % 10;
    }

    @Override
    public void left() {

    }

    @Override
    public void right() {

    }

    @Override
    public void select() {

        wonder.buyBricks(brickNumber, player1);
        System.out.println("Buying Bricks and changing phase.");
        endTurn();
    }

    @Override
    public void nextMode() {

    }

    @Override
    public void prevMode() {

    }

    @Override
    public void up() {

        cycleNumUp();
        System.out.println(toString());
    }

    @Override
    public void down() {

        cycleNumDown();
        System.out.println(toString());
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

        wonder.addNeutralBrick();
        getController().changeState(new MovePhaseControl( getController(),getGame()));
    }

    //testing only
    public String toString(){
        String s = "";
        s += ("How Many Bricks to Buy: " + brickNumber +
                "");
        return s;
    }
}
