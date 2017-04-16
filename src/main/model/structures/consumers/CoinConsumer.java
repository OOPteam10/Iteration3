package model.structures.consumers;

import model.resources.Coin;

/**
 * Created by allisonaguirre on 4/15/17.
 */
public interface CoinConsumer extends Consumer {
    public void addCoin(Coin coin);
}
