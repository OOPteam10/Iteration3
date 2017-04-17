package model.structures.producers.Visitor;

import model.structures.producers.secondary.SecondaryProducer;
import model.structures.producers.secondary.refinement.*;
import model.structures.producers.secondary.transportation.*;
import utilities.FileManager.FileInfoFactory;
import utilities.FileManager.ProducerFileInfo;

/**
 * Created by Doug on 4/16/2017.
 */
public class SecondaryProducerFileVisitor implements SecondaryProducerVisitor {

    private ProducerFileInfo info;

    public SecondaryProducerFileVisitor() {
        this.info = new ProducerFileInfo();
    }

    @Override
    public void visitCoalBurner(CoalBurner coalBurner) {
        this.info = FileInfoFactory.generateFileInfo(coalBurner);
    }

    @Override
    public void visitMint(Mint mint) {
        this.info = FileInfoFactory.generateFileInfo(mint);
    }

    @Override
    public void visitPaperMill(PaperMill paperMill) {
        this.info = FileInfoFactory.generateFileInfo(paperMill);
    }

    @Override
    public void visitSawMill(SawMill sawMill) {
        this.info = FileInfoFactory.generateFileInfo(sawMill);
    }

    @Override
    public void visitStockExchange(StockExchange stockExchange) {
        this.info = FileInfoFactory.generateFileInfo(stockExchange);
    }

    @Override
    public void visitStoneFactory(StoneFactory stoneFactory) {
        this.info = FileInfoFactory.generateFileInfo(stoneFactory);
    }

    @Override
    public void visitRaftFactory(RaftFactory raftFactory) {
        this.info = FileInfoFactory.generateFileInfo(raftFactory);
    }

    @Override
    public void visitRowboatFactory(RowboatFactory rowboatFactory) {
        this.info = FileInfoFactory.generateFileInfo(rowboatFactory);
    }

    @Override
    public void visitSteamerFactory(SteamerFactory steamerFactory) {
        this.info = FileInfoFactory.generateFileInfo(steamerFactory);
    }

    @Override
    public void visitTruckFactory(TruckFactory truckFactory) {
        this.info = FileInfoFactory.generateFileInfo(truckFactory);
    }

    @Override
    public void visitWagonFactory(WagonFactory wagonFactory) {
        this.info = FileInfoFactory.generateFileInfo(wagonFactory);
    }

    public ProducerFileInfo getInfo() {
        return info;
    }
}
