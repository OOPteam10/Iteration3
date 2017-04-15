package model.Transporters;


import model.TransporterControlAbilities.TransporterAbility;
import model.PlayerID;
import model.TransporterControlAbilities.AddTransporterToControlListAbility;
import model.TransporterControlAbilities.TransporterAbility;
import model.TransporterControlAbilities.TransporterAbilityFactory;
import model.structures.producers.Product;

/**
 * Created by hankerins on 4/8/17.
 */

public abstract class Transporter<L> implements Product<L> {
    protected PlayerID playerID;

    public PlayerID getPlayerID() {return playerID;}
    private TransporterAbility attcAbility;

    public void produceAbility(TransporterAbilityFactory f) {
        setAbility(f.makeTransporterAbility(this));
    }

    public void setAbility(TransporterAbility attcAbility) {
        this.attcAbility = attcAbility;
    }

    public void execute() {
        attcAbility.execute();
    }
}
