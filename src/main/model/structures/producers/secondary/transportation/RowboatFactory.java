package model.structures.producers.secondary.transportation;

import model.Managers.ResourceManager;
import model.Managers.SectorTransporterManager;
import model.Managers.TransporterManager;
import model.TileSubsystem.Sector;
import model.Transporters.Rowboat;
import model.resources.Board;
import model.structures.producers.SecondaryProducerTypeA;
import model.structures.producers.Visitor.SecondaryProducerVisitor;

/**
 * Created by cduica on 4/8/17.
 */
public class RowboatFactory extends SecondaryProducerTypeA<Board> {

    TransporterManager transporterManager;

    public RowboatFactory(ResourceManager resourceManager, SectorTransporterManager transporterManager) {
        super(resourceManager);
        this.transporterManager = transporterManager;
    }

    @Override
    public void produce(Sector l) {
        if(consumeRawResource()){
            transporterManager.add(new Rowboat(), l);
        }
    }

    @Override
    public void accept(SecondaryProducerVisitor v) {
        v.visitRowboatFactory(this);
    }

    @Override
    public void visitBoard(Board board) {
        giveResource(board);
    }
}
