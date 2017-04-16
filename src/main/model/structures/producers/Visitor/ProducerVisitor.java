package model.structures.producers.secondary.visitor;

/**
 * Created by Doug on 4/16/2017.
 */
public interface ProducerVisitor {
    void visitCoalBurner();
    void visitMint();
    void visitPaperMill();
    void visitSawMill();
    void visitStockExchange();
    void visitStoneFactory();
    void visitRaftFactory();
    void visitRowboatFactory();
    void visitSteamerFactory();
    void visitTruckFactory();
    void visitWagonFactory();
}
