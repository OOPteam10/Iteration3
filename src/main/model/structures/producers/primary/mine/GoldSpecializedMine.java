package model.structures.producers.primary.mine;

import model.Managers.ResourceManager;

/**
 * Created by Kevin on 4/16/17.
 */

public class GoldSpecializedMine extends Mine{

    public GoldSpecializedMine(ResourceManager resourceManager){
        super(resourceManager);

        ironCount = 0;
        goldCount = 4;
    }

}
