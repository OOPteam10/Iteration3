package utilities;
import model.Managers.CargoManager;
import model.PlayerID;
import model.Transporters.Steamship;
import model.Transporters.Transporter;
import model.Transporters.Visitor.LandTransporterFileVisitor;
import model.Transporters.Visitor.SeaTransporterFileVisitor;
import model.Transporters.Wagon;
import model.resources.Board;
import model.resources.Coin;
import model.structures.producers.Product;
import model.structures.producers.Visitor.ProductFileVisitor;
import org.junit.Test;
import utilities.FileManager.ProducerFileInfo;
import utilities.FileManager.TransporterFileInfo;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Doug on 4/16/2017.
 */
public class FileManagerTest {

    @Test
    public void wagonTest() {
        Wagon testWagon = new Wagon();
        CargoManager manager = new CargoManager();
        ArrayList<Product> cargo = new ArrayList<>();
        cargo.add(new Board());
        cargo.add(new Wagon());
        cargo.add(new Coin());
        manager.add(testWagon, cargo);
        PlayerID playerID = new PlayerID();
        testWagon.setPlayerID(playerID);
        LandTransporterFileVisitor visitor = new LandTransporterFileVisitor(manager);

        testWagon.accept(visitor);
        TransporterFileInfo info = (TransporterFileInfo) visitor.getFileInfo();

        assertEquals("Wagon " + playerID + " (Board Wagon Coin)", info.toFileFormat());
    }

    @Test
    public void coinTest() {
        Coin c = new Coin();

        ProductFileVisitor visitor = new ProductFileVisitor();

        c.accept(visitor);

        assertEquals("Coin", visitor.getFileInfo().toFileFormat());
    }

    @Test
    public void ProductVisitorTransporterTest() {
        Wagon wagon = new Wagon();

        ProductFileVisitor visitor = new ProductFileVisitor();

        wagon.accept(visitor);

        TransporterFileInfo wagonInfo = (TransporterFileInfo) visitor.getFileInfo();
        System.out.println("Size of cargo is "  + wagonInfo.getCargoSize());

        assertEquals("Wagon", wagonInfo.toFileFormat());
    }

    @Test
    public void emptyTransporterTest() {
        Steamship s = new Steamship();
        PlayerID pid = new PlayerID();
        s.setPlayerID(pid);

        CargoManager c = new CargoManager();

        SeaTransporterFileVisitor visitor = new SeaTransporterFileVisitor(c);

        s.accept(visitor);

        TransporterFileInfo info = visitor.getInfo();

        assertEquals("Steamship" + " " + pid.toString() , info.toFileFormat());
    }
    
}
