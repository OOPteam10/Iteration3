package model.structures.LogisticalStructures.visitor;

/**
 * Created by Doug on 4/16/2017.
 */
public interface visitLogisticalStructure {
    void visitBridge();
    void visitNeutralWall();
    void visitOwnedWall();
    void visitRoad();
}
