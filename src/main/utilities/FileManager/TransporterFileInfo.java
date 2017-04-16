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
        cargo = new ArrayList<>();
    }

    public TransporterFileInfo(String transporter, PlayerID ownerID, ArrayList<FileInfo> cargo) {
        this.transporter = transporter;
        this.ownerID = ownerID;
        this.cargo = cargo;
    }

    @Override
    public String toFileFormat() {

        String id;
        if (ownerID == null) {
            id = "";
        } else {
            id = " " + ownerID.toString();
        }


        if (cargo == null || cargo.isEmpty()) {
            return transporter + id;
        } else {
            String out = transporter + id + " (";
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

    public int getCargoSize() {
        return cargo.size();
    }
}
