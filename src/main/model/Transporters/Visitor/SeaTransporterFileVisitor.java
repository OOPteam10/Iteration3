package model.Transporters.Visitor;

import model.Managers.CargoManager;
import model.Transporters.Raft;
import model.Transporters.Rowboat;
import model.Transporters.Steamship;
import model.Transporters.Transporter;
import utilities.FileManager.FileInfo;
import utilities.FileManager.FileInfoFactory;
import utilities.FileManager.TransporterFileInfo;

/**
 * Created by Doug on 4/15/2017.
 */
public class SeaTransporterFileVisitor implements SeaTransporterVisitor {

    private TransporterFileInfo info;
    private CargoManager manager;

    public SeaTransporterFileVisitor(CargoManager c) {
        this.info = null;
        this.manager = c;
    }
    @Override
    public void visitRaft(Raft raft) {
        this.info = FileInfoFactory.generateFileInfo(raft, manager);
    }

    @Override
    public void visitRowboat(Rowboat rowboat) {
        this.info = FileInfoFactory.generateFileInfo(rowboat, manager);
    }

    @Override
    public void visitSteamship(Steamship steamship) {
        this.info = FileInfoFactory.generateFileInfo(steamship, manager);
    }

    public TransporterFileInfo getInfo() { return info; }
}
