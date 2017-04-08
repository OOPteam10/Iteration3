package model.Occupancies;

import model.producers.Producer;

/**
 * Created by hankerins on 4/8/17.
 */
public class ProducerOccupancy {
    private Producer occupyingProducer;

    public ProducerOccupancy(Producer producer){
        this.occupyingProducer = producer;
    }
    public Producer getOccupant(){
        return occupyingProducer;
    }
}
