package model.structures.producers.Visitor;

import model.Goose;
import model.Transporters.*;

/**
 * Created by Doug on 4/15/2017.
 */
public interface ProductVisitor {
    void visitBoard();
    void visitClay();
    void visitCoin();
    void visitFuel();
    void visitGold();
    void visitIron();
    void visitPaper();
    void visitStock();
    void visitStone();
    void visitTrunk();
    void visitDonkey(Donkey d);
    void visitWagon(Wagon w);
    void visitTruck(Truck t);
    void visitRaft(Raft r);
    void visitRowboat(Rowboat r);
    void visitSteamship(Steamship s);
    void visitGoose();
}
