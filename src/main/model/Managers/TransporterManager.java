package model.Managers;

/**
 * Created by hankerins on 4/8/17.
 * TODO: separate list managers and object managers
 */
public abstract class TransporterManager<Obj, Loc> extends TransporterAndProducerManager<Obj, Loc> {

    public void move(Obj o, Loc newLoc){
        removeOccupant(o);
        add(o, newLoc);
    }

}
