package controller.MovePhaseControlSubsystem;

import controller.ControlHandler;
import model.Managers.LandTransporterManager;
import model.Managers.SeaTransporterManager;
import model.Managers.SectorAdjacencyManager;
import view.MapMakerPreview;

import java.util.ArrayList;

/**
 * Created by hankerins on 4/10/17.
 *
 * we don't want singletons for the modes this time around, because
 * they should be created and destroyed based on whether or not the player
 * has the particular kind of transporter.
 *
 * the Control can hold an arraylist of the currently available modes (this is ok)
 */
public class MovePhaseControl implements ControlHandler {

    private ArrayList<MovePhaseControlMode> movePhaseControlModes;
    MovePhaseControlMode currentMovePhaseControlMode;

    private LandTransporterManager landTransporterManager;
    private SeaTransporterManager seaTransporterManager;
    private SectorAdjacencyManager sectorAdjacencyManager;
    private SectorAdjacencyManager roadAdjacencyManager;

    private void nextMode(){
        int next = (movePhaseControlModes.indexOf(currentMovePhaseControlMode)+1)
                % movePhaseControlModes.size();
        currentMovePhaseControlMode = movePhaseControlModes.get(next);
    }
    private void previousMode(){
        int previous = (movePhaseControlModes.indexOf(currentMovePhaseControlMode)-1
                + movePhaseControlModes.size()) % movePhaseControlModes.size();
        currentMovePhaseControlMode = movePhaseControlModes.get(previous);
    }

    private void nextTransporter(){
        currentMovePhaseControlMode.nextTransporter();
    }

    private void previousTransporter(){
        currentMovePhaseControlMode.previousTransporter();
    }

    private void cycleLeft(){
        currentMovePhaseControlMode.cycleLeft();
    }

    private void cycleRight(){
        currentMovePhaseControlMode.cycleRight();
    }

    public ArrayList<MovePhaseControlMode> getMovePhaseControlModes() {
        return movePhaseControlModes;
    }

    public MovePhaseControlMode getCurrentMovePhaseControlMode() {
        return currentMovePhaseControlMode;
    }

    public LandTransporterManager getLandTransporterManager() {
        return landTransporterManager;
    }

    public SeaTransporterManager getSeaTransporterManager() {
        return seaTransporterManager;
    }

    public SectorAdjacencyManager getSectorAdjacencyManager() {
        return sectorAdjacencyManager;
    }

    public SectorAdjacencyManager getRoadAdjacencyManager() {
        return roadAdjacencyManager;
    }


    //TODO: All Overridden functions call meaningfully named functions
    //TODO: rename ControlHandler functions to the name of the keypress

    @Override
    public void left() {
    }

    @Override
    public void right() {
    }

    @Override
    public void select() {
        currentMovePhaseControlMode.select();
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
    public void delete() {

    }

    @Override
    public void reset() {

    }

    @Override
    public void centerGravity() {

    }

    @Override
    public void init(MapMakerPreview preview) {

    }
}
