package model.structures.producers.primary.mine;

import model.Managers.ResourceManager;

/**
 * Created by Kevin on 4/16/17.
 */

public class BigMine extends Mine{

    public BigMine(ResourceManager resourceManager){
        super(resourceManager);

        ironCount = 5;
        goldCount = 5;

    }

}