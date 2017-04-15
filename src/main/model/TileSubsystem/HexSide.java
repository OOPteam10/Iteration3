package model.TileSubsystem;

/**
 * Created by hankerins on 3/28/17.
 */
public enum HexSide {
    N(CardinalDirection.NNW, CardinalDirection.NNE, 0),
    NE(CardinalDirection.NE, CardinalDirection.ENE, 60),
    SE(CardinalDirection.ESE, CardinalDirection.SE, 120),
    S(CardinalDirection.SSE, CardinalDirection.SSW, 180),
    SW(CardinalDirection.SW, CardinalDirection.WSW, 240),
    NW(CardinalDirection.WNW, CardinalDirection.NW, 300);

    private CardinalDirection cd1;
    private CardinalDirection cd2;
    private int degree;

    HexSide(CardinalDirection cd1, CardinalDirection cd2, int degree){
        this.cd1 = cd1;
        this.cd2 = cd2;
        this.degree = degree;
    }

    public CardinalDirection getFirstHalf() {
        return cd1;
    }

    public CardinalDirection getSecondHalf() {
        return cd2;
    }

    public int calculateAngle(HexSide comparison){
        int angle = comparison.degree - this.degree;
        if(angle < 0){
            angle += 360;
        }
        return angle;
    }

    public HexSide next(){
        int i = this.ordinal() + 1;
        i %= values().length;
        return values()[i];
    }
    public HexSide previous(){
        int i = this.ordinal() - 1;
        i += values().length;
        i %= values().length;
        return values()[i];
    }

    public HexSide getOppositeSide(){
        //rotate a HexSide 3 times
        HexSide opposite = this.next().next().next();
        return opposite;
    }
}
