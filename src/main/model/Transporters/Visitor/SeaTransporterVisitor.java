package model.Transporters.Visitor;

import model.Transporters.Raft;
import model.Transporters.Rowboat;
import model.Transporters.Steamship;

/**
 * Created by Karth on 4/12/2017.
 */
public interface SeaTransporterVisitor {
    void visitRaft(Raft raft);
    void visitRowboat(Rowboat rowboat);
    void visitSteamship(Steamship steamship);
}
