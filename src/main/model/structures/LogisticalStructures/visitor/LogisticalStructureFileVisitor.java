package model.structures.LogisticalStructures.visitor;

import model.structures.LogisticalStructures.Bridge;
import model.structures.LogisticalStructures.NeutralWall;
import model.structures.LogisticalStructures.OwnedWall;
import model.structures.LogisticalStructures.Road;
import utilities.FileManager.FileInfoFactory;
import utilities.FileManager.LogisticalStructureFileInfo;

/**
 * Created by Doug on 4/16/2017.
 */
public class LogisticalStructureFileVisitor implements LogisticalStructureVisitor {

    private LogisticalStructureFileInfo info;

    public LogisticalStructureFileVisitor() {
        this.info = new LogisticalStructureFileInfo();
    }

    @Override
    public void visitBridge(Bridge bridge) {
        this.info = FileInfoFactory.generateFileInfo(bridge);
    }

    @Override
    public void visitNeutralWall(NeutralWall neutralWall) {
        this.info = FileInfoFactory.generateFileInfo(neutralWall);
    }

    @Override
    public void visitOwnedWall(OwnedWall ownedWall) {
        this.info = FileInfoFactory.generateFileInfo(ownedWall);
    }

    @Override
    public void visitRoad(Road road) {
        this.info = FileInfoFactory.generateFileInfo(road);
    }
}
