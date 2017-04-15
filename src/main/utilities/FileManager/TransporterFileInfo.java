package utilities.FileManager;

import model.PlayerID;
import model.Transporters.Transporter;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Doug on 4/9/2017.
 */
public class TransporterFileInfo extends FileInfo{
    private PlayerID ownerID;
    private String transporter;
    private ArrayList<FileInfo> cargo;


    public TransporterFileInfo(String transporter, PlayerID ownerID) {
        this.transporter = transporter;
        this.ownerID = ownerID;
    }

    public TransporterFileInfo(String transporter, PlayerID ownerID, ArrayList<FileInfo> cargo) {
        this.transporter = transporter;
        this.ownerID = ownerID;
        this.cargo = cargo;
    }

    @Override
    public String toFileFormat() {
        if (cargo.isEmpty()) {
            return transporter + " " + ownerID;
        } else {
            String out = transporter + " " + ownerID + " (";
            String spacer = "";

            for (FileInfo f: cargo) {
                out += spacer + f.toFileFormat();
                spacer = " ";
            }

            out += ")";

            return out;
        }

    }

    public void addCargo(FileInfo f) {
        cargo.add(f);
    }
}
