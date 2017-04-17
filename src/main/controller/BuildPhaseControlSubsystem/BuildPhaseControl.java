package controller.BuildPhaseControlSubsystem;

import controller.Actions.NextMode;
import controller.Actions.PrevMode;
import controller.ControlHandler;
import controller.Controller;
import controller.KeyListener;
import controller.MovePhaseControlSubsystem.MovePhaseControl;
import javafx.scene.input.KeyCode;
import model.Abilities.buildAbilities.BuildRoadAbility;
import model.Abilities.buildAbilities.LandBuildAbility;
import model.Abilities.playerAbilityAvailability.BuildBigMineAbilityAvailability;
import model.Abilities.playerAbilityAvailability.PlayerAbilityAvailability;
import model.Game;
import model.ManagerSupplier;
import model.Managers.*;
import model.TileSubsystem.Sector;
import model.Transporters.LandTransporter;
import model.Transporters.SeaTransporter;

import java.util.ArrayList;

/**
 * Created by hankerins on 4/16/17.
 */
public class BuildPhaseControl extends ControlHandler {

    private ArrayList<LandBuildAbility> landBuildAbilities = new ArrayList<LandBuildAbility>();
    private LandBuildAbility currentAbility;

    private ArrayList<LandTransporter> landTransporters = new ArrayList<LandTransporter>();
    private ArrayList<SeaTransporter> seaTransporters = new ArrayList<SeaTransporter>();

    private LandTransporterManager landTransporterManager;
    private SeaTransporterShoreManager seaTransporterShoreManager;
    private ResourceManager resourceManager;
    private ManagerSupplier managerSupplier;


    private int currentTransporterIndex = 0;
    private BPCTransporterStrategy buildPhaseControlStrategy;


    public BuildPhaseControl(Controller controller, Game ms){
        super(controller, ms);
        landTransporterManager = ms.getLandTransporterManager();
        seaTransporterShoreManager = ms.getSeaTransporterShoreManager();
        resourceManager = ms.getResourceManager();
        managerSupplier = ms;

        landTransporters.addAll(landTransporterManager.getAll());
        seaTransporters.addAll(seaTransporterShoreManager.getAll());
        buildPhaseControlStrategy = new LandTransporterBPCStrategy();
        nextTransporter();
        resetAbilities();

        addAction(new NextMode(this), new KeyListener(KeyCode.M));
        addAction(new PrevMode(this), new KeyListener(KeyCode.N));
    }

    public void nextTransporter(){
        buildPhaseControlStrategy.nextTransporter(this);
        resetAbilities();
    }
    private void nextTransporter(int i){
        buildPhaseControlStrategy.nextTransporter(this);
        resetRecursion(i);
    }

    public void prevTransporter(){
        buildPhaseControlStrategy.prevTransporter(this);
        resetAbilities();

    }
    private void prevTransporter(int i){
        buildPhaseControlStrategy.prevTransporter(this);
        resetRecursion(i);

    }

    public void nextAbility(){
        int next = (landBuildAbilities.indexOf(currentAbility)+1) % landBuildAbilities.size();
        currentAbility = landBuildAbilities.get(next);
    }

    public void prevAbility(){
        int previous = (landBuildAbilities.indexOf(currentAbility)-1 + landBuildAbilities.size()) % landBuildAbilities.size();
        currentAbility = landBuildAbilities.get(previous);
    }

    public void resetAbilities(){
        resetRecursion(0);
    }
    private void resetRecursion(int i){
        if (i > 10){
            endTurn();
            return;
        }
        landBuildAbilities.clear();
        // TODO: pass in PlayerAbilityAvailabilityObject to get the actual shit: new BuildBigMineAbilityAvailability(new PlayerAbilityAvailability())
        landBuildAbilities.addAll(resourceManager.getLandProducerBuildAbilities(buildPhaseControlStrategy.getCurrentSector(this), new PlayerAbilityAvailability()));

        //ugly logic to get road directions
        ArrayList<Sector> adjacentSectors = managerSupplier.getSectorAdjacencyManager().getAdjacencyList(buildPhaseControlStrategy.getCurrentSector(this));
        ArrayList<Sector> toRemove = managerSupplier.getRoadAdjacencyManager().getAdjacencyList(buildPhaseControlStrategy.getCurrentSector(this));
        for(Sector s: toRemove){
            adjacentSectors.remove(s);
            adjacentSectors.remove(s);
        }
        for(Sector s: adjacentSectors){
            landBuildAbilities.add(new BuildRoadAbility(s));
        }
        if(landBuildAbilities.size() == 0){
            System.out.print("before: " + i);
            i++;
            nextTransporter(i);
        }else
        currentAbility = landBuildAbilities.get(0);
    }

    @Override
    public void left() {
        prevAbility();
        System.out.println(toString());
    }

    @Override
    public void right() {
        nextAbility();
        System.out.println(toString());
    }

    @Override
    public void select() {
        currentAbility.execute(buildPhaseControlStrategy.getCurrentSector(this), managerSupplier);
        resetAbilities();
        System.out.println(toString());
    }

    @Override
    public void moveNW() {

    }

    @Override
    public void moveN() {

    }

    @Override
    public void moveNE() {

    }

    @Override
    public void moveSW() {

    }

    @Override
    public void moveS() {

    }

    @Override
    public void moveSE() {

    }

    @Override
    public void nextMode() {
        nextTransporter();
        System.out.println(toString());
    }

    @Override
    public void prevMode() {
        prevTransporter();
        System.out.println(toString());
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
        getController().changeState(new MovePhaseControl( getController(),getGame()));
    }


    public ArrayList<LandTransporter> getLandTransporters() {
        return landTransporters;
    }

    public ArrayList<SeaTransporter> getSeaTransporters() {
        return seaTransporters;
    }

    public int getCurrentTransporterIndex() {
        return currentTransporterIndex;
    }

    public LandTransporterManager getLandTransporterManager() {
        return landTransporterManager;
    }

    public SeaTransporterShoreManager getSeaTransporterShoreManager() {
        return seaTransporterShoreManager;
    }

    public ResourceManager getResourceManager() {
        return resourceManager;
    }

    public void setCurrentTransporterIndex(int currentTransporterIndex) {
        this.currentTransporterIndex = currentTransporterIndex;
    }

    public void setBuildPhaseControlStrategy(BPCTransporterStrategy buildPhaseControlStrategy) {
        this.buildPhaseControlStrategy = buildPhaseControlStrategy;
    }

    //testing only
    public String toString(){
        String s = "";
        s += ("Transporter: " + buildPhaseControlStrategy.getCurrentTransporter(this).toString() +
                " Ability: " + currentAbility.toString());
        return s;
    }
}
