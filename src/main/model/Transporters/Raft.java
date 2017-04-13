package model.Transporters;

import model.Transporters.Visitor.SeaTransporterVisitor;

/**
 * Created by Karth on 4/12/2017.
 */
public class Raft extends SeaTransporter {
    @Override
    public void accept(SeaTransporterVisitor v){
        v.visitRaft(this);
    }
}
