package model.structures.producers.Visitor;

import model.structures.producers.secondary.refinement.*;
import model.structures.producers.secondary.transportation.*;

/**
 * Created by Doug on 4/16/2017.
 */
public interface SecondaryProducerVisitor {
    void visitCoalBurner(CoalBurner coalBurner);
    void visitMint(Mint mint);
    void visitPaperMill(PaperMill paperMill);
    void visitSawMill(SawMill sawMill);
    void visitStockExchange(StockExchange stockExchange);
    void visitStoneFactory(StoneFactory stoneFactory);
    void visitRaftFactory(RaftFactory raftFactory);
    void visitRowboatFactory(RowboatFactory rowboatFactory);
    void visitSteamerFactory(SteamerFactory steamerFactory);
    void visitTruckFactory(TruckFactory truckFactory);
    void visitWagonFactory(WagonFactory wagonFactory);
}
