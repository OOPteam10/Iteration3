package model.structures.producers.Visitor;

import model.structures.producers.Producer;
import model.structures.producers.primary.*;
import model.structures.producers.primary.mine.Mine;
import utilities.FileManager.FileInfo;
import utilities.FileManager.FileInfoFactory;
import utilities.FileManager.ProducerFileInfo;

/**
 * Created by Doug on 4/16/2017.
 */
public class PrimaryProducerFileVisitor implements PrimaryProducerVisitor {

    private ProducerFileInfo info;

    public PrimaryProducerFileVisitor() {
        this.info = new ProducerFileInfo();
    }

    @Override
    public void visitClayPit(ClayPit clayPit) {
        this.info = FileInfoFactory.generateFileInfo(clayPit);
    }

    @Override
    public void visitOilRig(OilRig oilRig) {
        this.info = FileInfoFactory.generateFileInfo(oilRig);
    }

    @Override
    public void visitStoneQuarry(StoneQuarry stoneQuarry) {
        this.info = FileInfoFactory.generateFileInfo(stoneQuarry);
    }

    @Override
    public void visitWoodCutter(WoodCutter woodCutter) {
        this.info = FileInfoFactory.generateFileInfo(woodCutter);
    }

    @Override
    public void visitMine(Mine mine) {
        this.info = FileInfoFactory.generateFileInfo(mine);
    }

    public ProducerFileInfo getInfo() {
        return info;
    }
}
