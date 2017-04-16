package controller.BuildPhaseControlSubsystem;

import controller.ControlHandler;
import model.Abilities.buildAbilities.BuildAbility;
import model.Abilities.buildAbilities.LandProducerBuildAbility;
import model.Managers.*;
import model.TileSubsystem.Sector;
import model.Transporters.LandTransporter;
import model.Transporters.SeaTransporter;
import model.Transporters.Transporter;
import view.Camera;
import view.MapMakerPreview;

import java.util.ArrayList;

/**
 * Created by hankerins on 4/16/17.
 */
public class BuildPhaseControl extends ControlHandler {

    private ArrayList<LandProducerBuildAbility> buildAbilities;
    LandProducerBuildAbility currentBuildAbility;

    private ArrayList<LandTransporter> landTransporters = new ArrayList<LandTransporter>();
    private ArrayList<SeaTransporter> seaTransporters = new ArrayList<SeaTransporter>();

    private LandTransporterManager landTransporterManager;
    private SeaTransporterShoreManager seaTransporterShoreManager;
    private ResourceManager resourceManager;
    private LandPrimaryProducerManager landPrimaryProducerManager;
    private LandSecondaryProducerManager landSecondaryProducerManager;

    private int currentIndex;
    private BuildPhaseControlStrategy buildPhaseControlStrategy;

    public BuildPhaseControl(LandTransporterManager ltm, SeaTransporterShoreManager stsm, ResourceManager rm,
                             LandPrimaryProducerManager lppm, LandSecondaryProducerManager lspm){
        landTransporterManager = ltm;
        seaTransporterShoreManager = stsm;
        resourceManager = rm;
        landPrimaryProducerManager = lppm;
        landSecondaryProducerManager = lspm;
        landTransporters.addAll(ltm.getAll());
        seaTransporters.addAll(stsm.getAll());
        currentIndex = 0;
        buildPhaseControlStrategy = new LandTransporterBPCStrategy();
        nextTransporter();
        buildAbilities = rm.getLandProducerBuildAbilities(buildPhaseControlStrategy.getCurrentSector(this));
        currentBuildAbility = buildAbilities.get(0);
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
        //currentBuildAbility.execute(buildPhaseControlStrategy.getCurrentSector(this), sec//HOW TO KNOW WHICH MANAGER?);
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
    public void init(MapMakerPreview preview, Camera camera) {

    }

    public ArrayList<LandTransporter> getLandTransporters() {
        return landTransporters;
    }

    public ArrayList<SeaTransporter> getSeaTransporters() {
        return seaTransporters;
    }

    public int getCurrentIndex() {
        return currentIndex;
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

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public void setBuildPhaseControlStrategy(BuildPhaseControlStrategy buildPhaseControlStrategy) {
        this.buildPhaseControlStrategy = buildPhaseControlStrategy;
    }
}
