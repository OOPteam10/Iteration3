package utilities.FileManager;

import java.util.ArrayList;

/**
 * Created by Doug on 4/9/2017.
 */
public class MineFileInfo extends ProducerFileInfo {
    private ArrayList<ResourceFileInfo> remainingProduct;

    public MineFileInfo(ArrayList<ResourceFileInfo> remainingProduct) {
        this.remainingProduct = remainingProduct;
        this.producer = "Mine";
    }

    public ArrayList<ResourceFileInfo> getRemainingProduct() {
        return remainingProduct;
    }

    @Override
    public String toFileFormat() {
        String out = producer + " (";
        String spacer = " ";
        for (ResourceFileInfo i: remainingProduct) {
            out += spacer + i.toFileFormat();
        }

        out += ")";

        return out;
    }
}
