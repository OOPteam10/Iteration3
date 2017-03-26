package model.TileSubsystem;

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

    CardinalDirection(int degree){
        this.degree = degree;
    }
}
