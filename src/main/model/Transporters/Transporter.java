package model.Transporters;



import model.PlayerID;
import model.structures.producers.Product;

/**
 * Created by hankerins on 4/8/17.
 */

public abstract class Transporter<L> implements Product<L> {
    protected PlayerID playerID;

    public PlayerID getPlayerID() {return playerID;}
}
