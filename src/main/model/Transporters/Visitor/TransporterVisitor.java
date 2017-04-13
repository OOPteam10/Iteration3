package model.Transporters.Visitor;

import model.Transporters.Donkey;
import model.Transporters.LandTransporter;

public interface TransporterVisitor {
    void visitLandTransporter(LandTransporter landTransporter);
    void visitDonkey(Donkey donkey);
}
