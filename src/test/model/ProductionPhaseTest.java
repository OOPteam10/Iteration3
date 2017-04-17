package model;

import model.Managers.LandPrimaryProducerManager;
import model.Managers.LandSecondaryProducerManager;
import model.Managers.ResourceManager;
import model.TileSubsystem.CardinalDirection;
import model.TileSubsystem.Sector;
import model.phases.ProductionPhase;
import model.resources.*;
import model.structures.producers.primary.ClayPit;
import model.structures.producers.primary.OilRig;
import model.structures.producers.primary.StoneQuarry;
import model.structures.producers.primary.WoodCutter;
import model.structures.producers.secondary.refinement.CoalBurner;
import org.junit.Test;

import static junit.framework.TestCase.fail;

/**
 *
 * Press F to pay respects
 *
 */
public class ProductionPhaseTest {

    @Test
    public void shouldProduceNewResourcesFromPrimaryProducers(){
        LandPrimaryProducerManager landPrimaryProducerManager = new LandPrimaryProducerManager();
        ResourceManager r = new ResourceManager();

        ProductionPhase p = new ProductionPhase(landPrimaryProducerManager, new LandSecondaryProducerManager(), null,
                null, null, null, null,
                r);

        Sector s1 = new Sector(CardinalDirection.NE, CardinalDirection.ESE);
        Sector s2 = new Sector(CardinalDirection.NE, CardinalDirection.ENE);
        Sector s3 = new Sector(CardinalDirection.NE, CardinalDirection.NE);
        Sector s4 = new Sector(CardinalDirection.NE, CardinalDirection.NNE);

        landPrimaryProducerManager.add(s1, new ClayPit(r));
        landPrimaryProducerManager.add(s2, new OilRig(r));
        landPrimaryProducerManager.add(s3, new StoneQuarry(r));
        landPrimaryProducerManager.add(s4, new WoodCutter(r));

        p.execute(null, null);


        assert (r.get(s1).get(0) instanceof Clay);
        assert (r.get(s2).get(0) instanceof Fuel);
        assert (r.get(s3).get(0) instanceof Stone);
        assert (r.get(s4).get(0) instanceof Trunk);

    }

    @Test
    public void shouldProduceNewResourcesFromSecondaryProducers(){
        LandSecondaryProducerManager landSecondaryProducerManager = new LandSecondaryProducerManager();
        ResourceManager r = new ResourceManager();

        ProductionPhase p = new ProductionPhase(new LandPrimaryProducerManager(), landSecondaryProducerManager, null,
                null, null, null, null,
                r);

        Sector s1 = new Sector(CardinalDirection.NE, CardinalDirection.ESE);
        r.add(s1, new Board());
        r.add(s1, new Trunk());
        landSecondaryProducerManager.add(s1, new CoalBurner(r));
        p.execute(null, null);
    }

}
