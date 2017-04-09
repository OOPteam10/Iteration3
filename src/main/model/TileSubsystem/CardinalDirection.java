package model.TileSubsystem;

import javax.smartcardio.Card;

/**
 * Created by hankerins on 3/26/17.
 */
public enum CardinalDirection {
    NNE(15),
    NE(45),
    ENE(75),
    ESE(105),
    SE(135),
    SSE(165),
    SSW(195),
    SW(225),
    WSW(255),
    WNW(285),
    NW(315),
    NNW(345);

    private final int degree;

    private CardinalDirection(int degree){
        this.degree = degree;
    }

    public CardinalDirection next(){
        int i = this.ordinal() + 1;
        i %= values().length;
        return values()[i];
    }
    public CardinalDirection previous(){
        int i = this.ordinal() - 1;
        i += values().length;
        i %= values().length;
        return values()[i];
    }

    public int calculateAngle(CardinalDirection comparison){
        int angle = comparison.degree - this.degree;
        if(angle < 0){
            angle += 360;
        }
        return angle;
    }

    public HexSide toHexSide(){
        return HexSide.values()[((ordinal()+1)%12)/2];
    }

    public CardinalDirection getOppositeSide(){
        //rotate a CD 6 times
        int offset = (ordinal()%2)*2;
        CardinalDirection opp = this;
        for(int i = 0; i < (5 + offset); i++){
            opp = opp.next();
        }
        return opp;
    }
}
