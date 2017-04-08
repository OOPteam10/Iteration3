package model.Occupancies;

/**
 * Created by hankerins on 4/8/17.
 */
public abstract class Occupancy<T2> {

    public abstract void add(T2 target);

    public abstract boolean contains(T2 target);
}
