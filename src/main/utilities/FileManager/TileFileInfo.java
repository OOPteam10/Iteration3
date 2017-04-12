package utilities.FileManager;

import model.TileSubsystem.HexSide;

import java.util.ArrayList;

/**
 * Created by doug0_000 on 3/27/2017.
 */
public class TileFileInfo extends FileInfo {
    private String terrain;
    private ArrayList<HexSide> riverEdges;

    public TileFileInfo() {
        this.terrain = "";
        riverEdges = new ArrayList<>();
    }

    public TileFileInfo(String terrain) {
        this.terrain = terrain;
        riverEdges = new ArrayList<>();
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public ArrayList<HexSide> getRiverEdges() {
        return riverEdges;
    }

    public void setRiverEdges(ArrayList<HexSide> riverEdges) {
        this.riverEdges = riverEdges;
    }

    @Override
    public String toFileFormat() {
        if (terrain == null) {
            System.out.println("Error converting tile to save data");
            return "";
        }
        String out = terrain;
        if (!riverEdges.isEmpty()){
            out += " (" + FileManager.edge_print(riverEdges) + ")";
        }

        return out;
    }
}