package controller.MapMakerControlSubsystem;

/**
 * Created by rishabh on 28/03/17.
 */
public interface MMCObserver {

    //move cursor around
    public void updateCursorN();
    public void updateCursorNE();
    public void updateCursorNW();
    public void updateCursorS();
    public void updateCursorSE();
    public void updateCursorSW();

    //terrain types
    public void updateTerrainToDesert();
    public void updateTerrainToMountain();
    public void updateTerrainToPasture();
    public void updateTerrainToRock();
    public void updateTerrainToSea();
    public void updateTerrainToWoods();

    //river types
    public void updateRiverToFork();
    public void updateRiverToNone();
    public void updateRiverToShape1();
    public void updateRiverToShape2();
    public void updateRiverToShape3();
    public void updateRiverToSource();

    //rotate rivers
    public void rotateLeft();
    public void rotateRight();

    //select
    public void terrainSelected();
    public void riverSelected();
    public void placeTile();

}
