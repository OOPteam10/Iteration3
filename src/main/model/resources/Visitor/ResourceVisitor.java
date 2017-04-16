package model.resources.Visitor;

import model.resources.*;

public interface ResourceVisitor {
    void visitBoard(Board board);
    void visitClay(Clay clay);
    void visitCoin(Coin coin);
    void visitFuel(Fuel fuel);
    void visitGold(Gold gold);
    void visitIron(Iron iron);
    void visitPaper(Paper paper);
    void visitStock(Stock stock);
    void visitStone(Stone stone);
    void visitTrunk(Trunk trunk);

}
