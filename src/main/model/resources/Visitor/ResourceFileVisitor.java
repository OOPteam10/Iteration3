package model.resources.Visitor;

import model.resources.*;
import utilities.FileManager.FileInfoFactory;
import utilities.FileManager.ResourceFileInfo;

/**
 * Created by Doug on 4/16/2017.
 */

public class ResourceFileVisitor implements ResourceVisitor {
    private ResourceFileInfo info;

    @Override
    public void visitBoard(Board board) {
        info = FileInfoFactory.generateFileInfo(board);
    }

    @Override
    public void visitClay(Clay clay) {
        info = FileInfoFactory.generateFileInfo(clay);
    }

    @Override
    public void visitCoin(Coin coin) {
        info = FileInfoFactory.generateFileInfo(coin);
    }

    @Override
    public void visitFuel(Fuel fuel) {
        info = FileInfoFactory.generateFileInfo(fuel);
    }

    @Override
    public void visitGold(Gold gold) {
        info = FileInfoFactory.generateFileInfo(gold);
    }

    @Override
    public void visitIron(Iron iron) {
        info = FileInfoFactory.generateFileInfo(iron);
    }

    @Override
    public void visitPaper(Paper paper) {
        info = FileInfoFactory.generateFileInfo(paper);
    }

    @Override
    public void visitStock(Stock stock) {
        info = FileInfoFactory.generateFileInfo(stock);
    }

    @Override
    public void visitStone(Stone stone) {
        info = FileInfoFactory.generateFileInfo(stone);
    }

    @Override
    public void visitTrunk(Trunk trunk) {
        info = FileInfoFactory.generateFileInfo(trunk);
    }

    public ResourceFileInfo getInfo() {
        return info;
    }
}
