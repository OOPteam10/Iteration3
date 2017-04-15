package utilities.FileManager;

/**
 * Created by Doug on 4/9/2017.
 */
public class ResourceFileInfo extends FileInfo{
    private String resource;

    public ResourceFileInfo(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}
