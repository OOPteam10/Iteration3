package model;

import model.MapSubsystem.Map;
import utilities.TileEditor;

/**
 * Created by cduica on 3/22/17.
 */
public class Game {

    private Map map;
    //private Player player

    public Game(){
        map = new Map();
        //instantiate tile editor
        TileEditor.getInstance().init(map);
    }
}
