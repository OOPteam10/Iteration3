package model.structures.producers.primary.mine;

import model.Managers.ResourceManager;
import model.TileSubsystem.Sector;
import model.resources.Gold;
import model.resources.Iron;
import model.structures.producers.primary.PrimaryProducer;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by cduica on 4/9/17.
 */
public abstract class Mine extends PrimaryProducer{

    private int ironCount, goldCount;

    public Mine(ResourceManager resourceManager) {
        super(resourceManager);
    }

    public void produce(Sector l){

        if(goldLeft() && ironLeft()){

            int rand = ThreadLocalRandom.current().nextInt(1, 11);

            if(rand > 5){

                addToResourceManager(l, new Iron());
                decrementIron();
            }else{

                addToResourceManager(l, new Gold());
                decrementGold();
            }
        }else if(goldLeft()){

            addToResourceManager(l, new Gold());
            decrementGold();
        }else if(ironLeft()){

            addToResourceManager(l, new Iron());
            decrementIron();
        }else{

            // does nothing, no more to produce
        }
    }

    protected void setIronCount(int count){
        this.ironCount = count;
    }

    protected void setGoldCount(int count){
        this.goldCount = count;
    }

    public void buildShaft(Mine shaft){

        addIron( shaft.getIronCount() );
        addGold( shaft.getGoldCount() );
    }

    private void decrementIron(){
        ironCount--;
    }

    private void decrementGold(){
        goldCount--;
    }

    private boolean goldLeft(){

        return (goldCount > 0);
    }

    private boolean ironLeft(){

        return (ironCount > 0);
    }

    protected void addGold(int count){

        goldCount += count;
    }

    protected void addIron(int count){

        ironCount += count;
    }

    public int getGoldCount() {
        return goldCount;
    }

    public int getIronCount() {
        return ironCount;
    }
}
