package utilities.FileManager;

import java.util.ArrayList;

/**
 * Created by Doug on 4/11/2017.
 */
public class OilRigFileInfo extends ProducerFileInfo {
    private ArrayList<FileInfo> cargo;

    public OilRigFileInfo() {
        producer = "Oil Rig";
        cargo = null;
    }

    public OilRigFileInfo(ArrayList<FileInfo> cargo) {
        producer = "Oil Rig";
        this.cargo = cargo;
    }

    @Override
    public String toFileFormat() {
        if (cargo.isEmpty()) {
            return producer;
        } else {
            String out =  producer + " (";
            String spacer = "";

            for (FileInfo f: cargo) {
                out += spacer + f.toFileFormat();
            }

            return out;
        }
    }
}
