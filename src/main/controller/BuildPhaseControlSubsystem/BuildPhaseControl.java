package controller.BuildPhaseControlSubsystem;

import controller.ControlHandler;
import model.Abilities.buildAbilities.BuildAbility;
import model.Abilities.buildAbilities.LandProducerBuildAbility;
import model.Abilities.buildAbilities.LogisticalStructureBuildAbility;
import model.ManagerSupplier;
import model.Managers.*;
import model.Transporters.LandTransporter;
import model.Transporters.SeaTransporter;

import java.util.ArrayList;

/**
 * Created by hankerins on 4/16/17.
 */
public class BuildPhaseControl extends ControlHandler {

    private ArrayList<LandProducerBuildAbility> producerBuildAbilities;
    LandProducerBuildAbility currentProducerBuildAbility;


    private ArrayList<LandTransporter> landTransporters = new ArrayList<LandTransporter>();
    private ArrayList<SeaTransporter> seaTransporters = new ArrayList<SeaTransporter>();

    private LandTransporterManager landTransporterManager;
    private SeaTransporterShoreManager seaTransporterShoreManager;
    private ResourceManager resourceManager;
    private ManagerSupplier managerSupplier;


    private int currentTransporterIndex;
    private int currentBuildAbilityIndex;
    private BuildPhaseControlStrategy buildPhaseControlStrategy;

    public BuildPhaseControl(LandTransporterManager ltm, SeaTransporterShoreManager stsm, ResourceManager rm, ManagerSupplier ms){
        landTransporterManager = ltm;
        seaTransporterShoreManager = stsm;
        resourceManager = rm;
        managerSupplier = ms;

        landTransporters.addAll(ltm.getAll());
        seaTransporters.addAll(stsm.getAll());
        currentTransporterIndex = 0;
        buildPhaseControlStrategy = new LandTransporterBPCStrategy();
        nextTransporter();
        producerBuildAbilities = rm.getLandProducerBuildAbilities(buildPhaseControlStrategy.getCurrentSector(this));
        currentProducerBuildAbility = producerBuildAbilities.get(0);
    }

    public void nextTransporter(){
        buildPhaseControlStrategy.nextTransporter(this);
    }

    public void prevTransporter(){
        buildPhaseControlStrategy.prevTransporter(this);
    }

    @Override
    public void left() {
        prevTransporter();
    }

    @Override
    public void right() {
        nextTransporter();
    }

    @Override
    public void select() {
        //currentProducerBuildAbility.execute(buildPhaseControlStrategy.getCurrentSector(this), sec//HOW TO KNOW WHICH MANAGER?);
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

    public void setBuildPhaseControlStrategy(BuildPhaseControlStrategy buildPhaseControlStrategy) {
        this.buildPhaseControlStrategy = buildPhaseControlStrategy;
    }
}
