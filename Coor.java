/* Coor.java
 * (c) 2016 Riwaz Poudyal, Mark Talbot, Julian Vera
 * Immutable POJO to hold a coordinate
 */

import java.util.ArrayList;

public class Coor {

    private final int X;
    private final int Y;

    public Coor(int x, int y) {
        this.X = x;
        this.Y = y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public String toString() {
        return ("("+X+","+Y+")");
    }

    public boolean equals(Coor coor) {
        return (this.X == coor.getX() && this.Y == coor.getY());
    }

    public static ArrayList<Coor> getAdjacentCoors(Coor c) {
        ArrayList<Coor> result = new ArrayList<>();
        if (c.getX() + 1 < Params.MAX_ROW) result.add(new Coor(c.getX() + 1, c.getY()));
        if (c.getX() - 1 >= 0) result.add(new Coor(c.getX() - 1, c.getY()));
        if (c.getY() + 1 < Params.MAX_COL) result.add(new Coor(c.getX(), c.getY() + 1));
        if (c.getY() - 1 >= 0) result.add(new Coor(c.getX(), c.getY() - 1));
        return result;
    }

    // returns true iff coor1 is diagonal to coor2 and they are adjacent (no another diagonal coor)
    public static boolean isDiagonalTo(Coor coor1, Coor coor2) {
        if ((java.lang.Math.abs(coor1.getX() - coor2.getX()) == 1) && (java.lang.Math.abs(coor1.getY() - coor2.getY()) == 1)) {
            return true;
        }
        return false;
    }

    public static Coor getCenterCoor(Coor coor1, Coor coor2) {
        return new Coor((coor1.getX() + coor2.getX())/2, (coor1.getY() + coor2.getY())/2);
    }

    /**
     *
     * TEST CODE
     */
    public static void main(String[] args) {

    }
}