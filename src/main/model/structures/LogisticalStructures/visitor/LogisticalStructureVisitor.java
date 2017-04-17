package model.structures.LogisticalStructures.visitor;

import model.structures.LogisticalStructures.Bridge;
import model.structures.LogisticalStructures.NeutralWall;
import model.structures.LogisticalStructures.OwnedWall;
import model.structures.LogisticalStructures.Road;

/**
 * Created by Doug on 4/16/2017.
 */
public interface LogisticalStructureVisitor {
    void visitBridge(Bridge bridge);
    void visitNeutralWall(NeutralWall neutralWall);
    void visitOwnedWall(OwnedWall ownedWall);
    void visitRoad(Road road);

}
