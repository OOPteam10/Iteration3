package utilities.FileManager;

/**
 * Created by Doug on 4/11/2017.
 */
public class ProducerFileInfo extends FileInfo{
    protected String producer;

    public ProducerFileInfo(String producer) {
        this.producer = producer;
    }

    public ProducerFileInfo() {
        this.producer = null;
    }

    @Override
    public String toFileFormat() {
        return producer;
    }
}
