package model.structures.producers.primary.mine;

import model.Managers.ResourceManager;

/**
 * Created by Kevin on 4/16/17.
 */

public class NormalMine extends Mine{

    public NormalMine(ResourceManager resourceManager){
        super(resourceManager);

        ironCount = 3;
        goldCount = 3;
    }

}