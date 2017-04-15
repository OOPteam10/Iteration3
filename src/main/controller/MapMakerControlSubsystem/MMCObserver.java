package controller.MapMakerControlSubsystem;

/**
 * Created by rishabh on 28/03/17.
 */
public interface MMCObserver {

    //move cursor around
    void updateCursorN();
    void updateCursorNE();
    void updateCursorNW();
    void updateCursorS();
    void updateCursorSE();
    void updateCursorSW();

    //terrain types
    void updateTerrainToDesert();
    void updateTerrainToMountain();
    void updateTerrainToPasture();
    void updateTerrainToRock();
    void updateTerrainToSea();
    void updateTerrainToWoods();

    //river types
    void updateRiverToFork();
    void updateRiverToNone();
    void updateRiverToShape1();
    void updateRiverToShape2();
    void updateRiverToShape3();
    void updateRiverToSource();

    //rotate rivers
    void rotateLeft();
    void rotateRight();

    //select
    void terrainSelected();
    void riverSelected();
    void placeTile();

}
