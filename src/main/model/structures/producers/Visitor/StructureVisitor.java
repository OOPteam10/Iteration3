package model.structures.producers.Visitor;

/**
 * Created by Doug on 4/15/2017.
 */

//lol visitors

public interface StructureVisitor {
    void visitRaftFactory();
    void visitRowBoatFactory();
    void visitSteamerFactory();
    void visitTruckFactory();
    void visitWagonFactory();
    void visitStoneFactory();
    void visitStockExchange();
    void visitSawMill();
    void visitPaperMill();
    void visitCoalBurner();
    void visitClayPit();
    void visitOilRig();
    void visitStoneQuarry();
    void visitWoodCutter();
    void visitBridge();
    void visitNeutralWall(); 
    void visitOwnedWall();
    void visitRoad();
}
