package utilities.FileManager;

import model.Goose;
import model.Transporters.Donkey;
import model.resources.*;

/**
 * Created by Doug on 4/9/2017.
 */
public class FileInfoFactory {

    /*
    ~~~REPOST THIS IF YOU'RE A STRONG INDEPENDENT DESIGN PATTERN~~~~~
                ~~~~[WHO DON'T NEED NO CONDITIONAL LOGIC]~~~~
     */

    //Resources

    public static ResourceFileInfo generateFileInfo(Paper p) {
        return new ResourceFileInfo("Paper");
    }

    public static ResourceFileInfo generateFileInfo(Stone s) {
        return new ResourceFileInfo("Stone");
    }

    public static ResourceFileInfo generateFileInfo(Stock s) {
        return new ResourceFileInfo("Stock");
    }

    public static ResourceFileInfo generateFileInfo(Trunk t) {
        return new ResourceFileInfo("Trunk");
    }

    public static ResourceFileInfo generateFileInfo(Iron i) {
        return new ResourceFileInfo("Iron");
    }

    public static ResourceFileInfo generateFileInfo(Gold g) {
        return new ResourceFileInfo("Gold");
    }

    public static ResourceFileInfo generateFileInfo(Fuel f) {
        return new ResourceFileInfo("Fuel");
    }

    public static ResourceFileInfo generateFileInfo(Coins c) {
        return new ResourceFileInfo("Coins");
    }

    public static ResourceFileInfo generateFileInfo(Clay c) {
        return new ResourceFileInfo("Clay");
    }

    public static ResourceFileInfo generateFileInfo(Board b) {
        return new ResourceFileInfo("Board");
    }

    //Transporters

    public static TransporterFileInfo generateFileInfo(Donkey d) { return new TransporterFileInfo("Donkey", "#GET_DONKEY_USERID"); }

    //Goose

    public static GooseFileInfo generateFileInfo(Goose g) {return new GooseFileInfo(); }
}

