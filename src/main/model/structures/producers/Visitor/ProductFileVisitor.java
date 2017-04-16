package model.structures.producers.Visitor;

import model.Goose;
import model.Transporters.*;
import utilities.FileManager.FileInfo;
import utilities.FileManager.GooseFileInfo;
import utilities.FileManager.ResourceFileInfo;
import utilities.FileManager.TransporterFileInfo;

import java.io.File;

/**
 * Created by Doug on 4/15/2017.
 */
public class ProductFileVisitor implements ProductVisitor {
    private FileInfo fileInfo;

    public ProductFileVisitor() {
        this.fileInfo = null;
    }

    @Override
    public void visitBoard() {
        this.fileInfo = new ResourceFileInfo("Board");
    }

    @Override
    public void visitClay() {
        this.fileInfo = new ResourceFileInfo("Clay");
    }

    @Override
    public void visitCoin() {
        this.fileInfo = new ResourceFileInfo("Coin");
    }

    @Override
    public void visitFuel() {
        this.fileInfo = new ResourceFileInfo("Fuel");
    }

    @Override
    public void visitGold() {
        this.fileInfo = new ResourceFileInfo("Gold");
    }

    @Override
    public void visitIron() {
        this.fileInfo = new ResourceFileInfo("Iron");
    }

    @Override
    public void visitPaper() {
        this.fileInfo = new ResourceFileInfo("Paper");
    }

    @Override
    public void visitStock() {
        this.fileInfo = new ResourceFileInfo("Stock");
    }

    @Override
    public void visitStone() {
        this.fileInfo = new ResourceFileInfo("Stone");
    }

    @Override
    public void visitTrunk() {
        this.fileInfo = new ResourceFileInfo("Trunk");
    }

    @Override
    public void visitDonkey(Donkey d) {
        this.fileInfo = new TransporterFileInfo("Donkey", d.getPlayerID());
    }

    @Override
    public void visitWagon(Wagon w) {
        this.fileInfo = new TransporterFileInfo("Wagon", w.getPlayerID());
    }

    @Override
    public void visitTruck(Truck t) {
        this.fileInfo = new TransporterFileInfo("Truck", t.getPlayerID());
    }

    @Override
    public void visitRaft(Raft r) {
        this.fileInfo = new TransporterFileInfo("Raft", r.getPlayerID());
    }

    @Override
    public void visitRowboat(Rowboat r) {
        this.fileInfo = new TransporterFileInfo("Rowboat", r.getPlayerID());
    }

    @Override
    public void visitSteamship(Steamship s) {
        this.fileInfo = new TransporterFileInfo("Steamship", s.getPlayerID());
    }

    @Override
    public void visitGoose() {
        this.fileInfo = new GooseFileInfo();
    }

    public FileInfo getFileInfo() { return fileInfo; }
}
