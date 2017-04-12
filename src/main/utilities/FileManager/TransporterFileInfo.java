package utilities.FileManager;

import model.Transporters.Transporter;

import java.io.File;

/**
 * Created by Doug on 4/9/2017.
 */
public class TransporterFileInfo extends FileInfo{
    private String ownerID;
    private String transporter;
    private FileInfo cargo;


    public TransporterFileInfo(String transporter, String ownerID) {
        this.transporter = transporter;
        this.ownerID = ownerID;
    }

    public TransporterFileInfo(String transporter, String ownerID, FileInfo cargo) {
        this.transporter = transporter;
        this.ownerID = ownerID;
        this.cargo = cargo;
    }

    @Override
    public String toFileFormat() {
        if (cargo == null) {
            return transporter + " " + ownerID;
        } else {
            return transporter + " " + ownerID + " " + cargo.toFileFormat();
        }

    }
}
