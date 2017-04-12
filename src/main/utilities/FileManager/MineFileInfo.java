package utilities.FileManager;

import model.resources.Resource;

import java.util.ArrayList;

/**
 * Created by Doug on 4/9/2017.
 */
public class MineFileInfo extends FileInfo {
    private ArrayList<ResourceFileInfo> remainingProduct;


    public ArrayList<ResourceFileInfo> getRemainingProduct() {
        return remainingProduct;
    }

    @Override
    public String toFileFormat() {
        String out = "(";
        String spacer = " ";
        for (ResourceFileInfo i: remainingProduct) {
            out += spacer + i.toFileFormat();
        }

        out += ")";

        return out;
    }
}
