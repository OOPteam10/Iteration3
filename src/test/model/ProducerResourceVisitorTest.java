package model;

import model.Managers.ResourceManager;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.Sector;
import model.resources.Board;
import model.resources.Fuel;
import model.resources.Resource;
import model.resources.Trunk;
import model.structures.producers.secondary.refinement.SawMill;
import org.junit.Test;

import java.util.List;

/**
 * Created by cduica on 4/16/17.
 */
public class ProducerResourceVisitorTest {

    @Test
    public void shouldAddResourcesToProducer(){
        ResourceManager resourceManager = new ResourceManager();
        Sector s = new Sector(CardinalDirection.NE, CardinalDirection.NNE);
        Trunk t = new Trunk();
        resourceManager.add(s, t);
        SawMill sawMill = new SawMill(resourceManager);
        List<Resource> resources = resourceManager.get(s);
        for(Resource r: resources){
            r.accept(sawMill);
        }
        sawMill.produce(s);
        assert(resourceManager.get(s).get(0) instanceof Board);
    }

}
