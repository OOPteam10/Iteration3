package controller.BuildPhaseControlSubsystem;

import controller.ControlHandler;
import model.Abilities.buildAbilities.BuildRoadAbility;
import model.Abilities.buildAbilities.LandBuildAbility;
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


    public BuildPhaseControl(LandTransporterManager ltm, SeaTransporterShoreManager stsm, ResourceManager rm, ManagerSupplier ms){
        landTransporterManager = ltm;
        seaTransporterShoreManager = stsm;
        resourceManager = rm;
        managerSupplier = ms;

        landTransporters.addAll(ltm.getAll());
        seaTransporters.addAll(stsm.getAll());
        buildPhaseControlStrategy = new LandTransporterBPCStrategy();
        nextTransporter();
        landBuildAbilities.addAll(rm.getLandProducerBuildAbilities(buildPhaseControlStrategy.getCurrentSector(this)));

        //ugly logic to get road directions
        ArrayList<Sector> adjacentSectors = ms.getSectorAdjacencyManager().getAdjacencyList(buildPhaseControlStrategy.getCurrentSector(this));
        ArrayList<Sector> toRemove = ms.getRoadAdjacencyManager().getAdjacencyList(buildPhaseControlStrategy.getCurrentSector(this));
        for(Sector s: toRemove){
            adjacentSectors.remove(s);
        }
        for(Sector s: adjacentSectors){
            landBuildAbilities.add(new BuildRoadAbility(s));
        }
        currentAbility = landBuildAbilities.get(0);
    }

    public void nextTransporter(){
        buildPhaseControlStrategy.nextTransporter(this);
    }

    public void prevTransporter(){
        buildPhaseControlStrategy.prevTransporter(this);
    }

    public void nextAbility(){
        int next = (landBuildAbilities.indexOf(currentAbility)+1) % landBuildAbilities.size();
        currentAbility = landBuildAbilities.get(next);
    }

    public void prevAbility(){
        int previous = (landBuildAbilities.indexOf(currentAbility)-1 + landBuildAbilities.size()) % landBuildAbilities.size();
        currentAbility = landBuildAbilities.get(previous);
    }

    @Override
    public void left() {
        prevAbility();
    }

    @Override
    public void right() {
        nextAbility();
    }

    @Override
    public void select() {
        currentAbility.execute(buildPhaseControlStrategy.getCurrentSector(this), managerSupplier);
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

    }

    @Override
    public void prevMode() {

    }

    @Override
    public void up() {
        prevTransporter();
    }

    @Override
    public void down() {
        nextTransporter();
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
}
