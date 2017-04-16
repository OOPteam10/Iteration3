package model.structures.producers.primary.mine;

import model.Managers.ResourceManager;

/**
 * Created by Kevin on 4/16/17.
 */

public class IronSpecializedMine extends Mine{

    public IronSpecializedMine(ResourceManager resourceManager){
        super(resourceManager);

        ironCount = 4;
        goldCount = 0;
    }

}
