package utilities.FileManager;

/**
 * Created by Doug on 4/16/2017.
 */
public class LogisticalStructureFileInfo extends FileInfo {

    private String logisticalStructure;

    public LogisticalStructureFileInfo(String logisticalStructure) {
        this.logisticalStructure = logisticalStructure;
    }

    public LogisticalStructureFileInfo() {
        this.logisticalStructure =  "NOT SET";
    }

    @Override
    public String toFileFormat() {
        return logisticalStructure;
    }
}
