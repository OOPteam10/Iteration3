package view;

import controller.MapMakerControlSubsystem.MMCObserver;

public class MapMakerPreview implements MMCObserver{
    private PanelManager panelManager;
    private int rotation;
    public MapMakerPreview(PanelManager panelManager){
        this.rotation = 0;
        this.panelManager = panelManager;
    }
    //MMCObserver methods
    @Override
    public void updateTerrainToDesert() {
        System.out.println("in MMpREVIEW UPDATE TERRAIN TO DESERT");
        panelManager.updateTerrainPreview("DESERT_TILE");
    }

    @Override
    public void updateTerrainToMountain() {
        panelManager.updateTerrainPreview("MOUNTAIN_TILE");
    }

    @Override
    public void updateTerrainToPasture() {
        panelManager.updateTerrainPreview("GRASS_TILE");
    }

    @Override
    public void updateTerrainToRock() {
        panelManager.updateTerrainPreview("ROCK_TILE");
    }

    @Override
    public void updateTerrainToSea() {
        panelManager.updateTerrainPreview("SEA_TILE");
    }

    @Override
    public void updateTerrainToWoods() {
        panelManager.updateTerrainPreview("WOOD_TILE");
    }

    @Override
    public void updateRiverToFork() {
        panelManager.updateRiverPreview("FORKED_RIVER");
    }

    @Override
    public void updateRiverToNone() {
        panelManager.updateRiverPreview("EMPTY_HEX_GRID");
    }

    @Override
    public void updateRiverToShape1() {
        panelManager.updateRiverPreview("NORMAL_RIVER_60");
    }

    @Override
    public void updateRiverToShape2() {
        panelManager.updateRiverPreview("NORMAL_RIVER_120");
    }

    @Override
    public void updateRiverToShape3() {
        panelManager.updateRiverPreview("NORMAL_RIVER_180");
    }

    @Override
    public void updateRiverToSource() {
        panelManager.updateRiverPreview("SOURCE_RIVER");
    }

    @Override
    public void updateCursorN() {

    }

    @Override
    public void updateCursorNE() {

    }

    @Override
    public void updateCursorNW() {

    }

    @Override
    public void updateCursorS() {

    }

    @Override
    public void updateCursorSE() {

    }

    @Override
    public void updateCursorSW() {

    }

    @Override
    public void placeTile(){
        panelManager.updateTerrainPreview("DESERT_TILE");
        panelManager.updateRiverPreview("NORMAL_RIVER_60");
        rotation = 0;
        panelManager.updateRotation(rotation%4);
        panelManager.selectTerrain();
    }

    @Override
    public void terrainSelected() {
        panelManager.selectRiver();
    }

    @Override
    public void riverSelected() {
        panelManager.selectFinal();
    }

    @Override
    public void rotateLeft() {
        rotation--;
        if(rotation < 0){
            rotation += 6;
        }
        panelManager.updateRotation(rotation%6);
    }
    @Override
    public void rotateRight(){
        rotation++;
        if(rotation > 6){
            rotation -= 6;
        }
        panelManager.updateRotation(rotation%6);

    }
}
