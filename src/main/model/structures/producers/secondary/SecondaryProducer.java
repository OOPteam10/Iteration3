package model.structures.producers.secondary;

import model.Managers.ResourceManager;
import model.resources.*;
import model.resources.Visitor.ResourceVisitor;
import model.structures.producers.Producer;

/**
 * Created by cduica on 4/8/17.
 */
public abstract class SecondaryProducer extends Producer implements ResourceVisitor {

    abstract protected boolean consumeRawResource();

    public SecondaryProducer(ResourceManager resourceManager){
        super(resourceManager);
    }

    @Override
    public void visitBoard(Board board) {

    }

    @Override
    public void visitClay(Clay clay) {

    }

    @Override
    public void visitCoin(Coin coin) {

    }

    @Override
    public void visitFuel(Fuel fuel) {

    }

    @Override
    public void visitGold(Gold gold) {

    }

    @Override
    public void visitIron(Iron iron) {

    }

    @Override
    public void visitPaper(Paper paper) {

    }

    @Override
    public void visitStock(Stock stock) {

    }

    @Override
    public void visitStone(Stone stone) {

    }

    @Override
    public void visitTrunk(Trunk trunk) {

    }
}
