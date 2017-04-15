package model.Managers;

import model.TileSubsystem.Sector;
import model.structures.producers.Producer;

import java.util.Map;

/**
 * Created by allisonaguirre on 4/11/17.
 */
public abstract class LandProducerManager<P extends Producer> extends ProducerManager<Sector, P>{
    @Override
    public void produceAll() {
        for(Map.Entry<Sector, P> e : getManagerMap().entrySet()){
            e.getValue().produce(e.getKey());
        }
    }
}
