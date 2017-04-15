package model.resources;

import model.Managers.GoodsManager;
import model.TileSubsystem.Sector;
import model.resources.Visitor.ResourceVisitor;

/**
 * Created by cduica on 4/9/17.
*/
public class Coin extends Resource {


    //testing only
    public String toString(){
        return "Coins";
    }

    @Override
    public void accept(ResourceVisitor v) {
        v.visitCoin();
    }
}
