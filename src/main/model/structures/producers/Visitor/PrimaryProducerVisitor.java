package model.structures.producers.Visitor;

import model.structures.producers.primary.ClayPit;
import model.structures.producers.primary.OilRig;
import model.structures.producers.primary.StoneQuarry;
import model.structures.producers.primary.WoodCutter;
import model.structures.producers.primary.mine.Mine;

public interface PrimaryProducerVisitor {
    void visitClayPit(ClayPit clayPit);
    void visitOilRig(OilRig oilRig);
    void visitStoneQuarry(StoneQuarry stoneQuarry);
    void visitWoodCutter(WoodCutter woodCutter);
    void visitMine(Mine mine);
}
