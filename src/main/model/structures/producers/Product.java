package model.structures.producers;

import model.TileSubsystem.Sector;
import model.TileSubsystem.Waterway;
import model.structures.producers.Visitor.ProductVisitor;

/**
 * Created by cduica on 4/8/17.
 */
public interface Product<L> {
    void dropOff(Sector s);
    void dropOff(Waterway w);


    void accept(ProductVisitor v);
    //try adding a dropOff(Sector s) and see if it can be called by a Product<Waterway> to go into adjacent waterway
}
