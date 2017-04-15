package model.resources.Visitor;

public interface ResourceVisitor {
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
}
