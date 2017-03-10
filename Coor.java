/* Coor.java
 * (c) 2016 Riwaz Poudyal, Mark Talbot, Julian Vera
 * Immutable POJO to hold a coordinate
 */

import java.util.ArrayList;
import java.util.List;

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

    public static List<Coor> getAdjacentCoors(Coor c) {
        ArrayList<Coor> result = new ArrayList<>();
        if (c.getX() + 1 < Params.MAX_ROW) result.add(new Coor(c.getX() + 1, c.getY()));
        if (c.getX() - 1 >= 0) result.add(new Coor(c.getX() - 1, c.getY()));
        if (c.getY() + 1 < Params.MAX_COL) result.add(new Coor(c.getX(), c.getY() + 1));
        if (c.getY() - 1 >= 0) result.add(new Coor(c.getX(), c.getY() - 1));
        return result;
    }

    // returns true iff coor1 is diagonal to coor2 and they are adjacent (no another diagonal coor)
    public static boolean isDiagonalTo(Coor coor1, Coor coor2) {
        if ((java.lang.Math.abs(coor1.getX() - coor2.getX()) == 1)
                && (java.lang.Math.abs(coor1.getY() - coor2.getY()) == 1)) {
            return true;
        }
        return false;
    }

    public static Coor getCenterCoor(Coor coor1, Coor coor2) {
        return new Coor((coor1.getX() + coor2.getX())/2, (coor1.getY() + coor2.getY())/2);
    }

    // Needs reworking
    public static List<Coor> getDiagonalCoors(Coor coor) {
        int x = coor.getX();
        int y = coor.getY();
        List<Coor> results = new ArrayList<>();
        if (x + 1 < Params.MAX_ROW && y + 1 < Params.MAX_COL) {
            results.add(new Coor(x + 1, y + 1));
        }
        if (x - 1 >= 0 && y - 1 >= 0) {
            results.add(new Coor(x - 1, y - 1));
        }
        if (x + 1 < Params.MAX_ROW && y - 1 >= 0) {
            results.add(new Coor(x + 1, y - 1));
        }
        if (x - 1 >= 0 && y + 1 < Params.MAX_COL) {
            results.add(new Coor(x - 1, y + 1));
        }
        return results;
    }

    public static List<Coor> getRedForwardCoors(Coor coor) {
        List<Coor> results = new ArrayList<>();
        if (coor.getX() - 1 >= 0 && coor.getY() - 1 >= 0) {
            results.add(new Coor(coor.getX() - 1, coor.getY() - 1));
        }
        if (coor.getX() - 1 >= 0 && coor.getY() + 1 < Params.MAX_COL) {
            results.add(new Coor(coor.getX() - 1, coor.getY() + 1));
        }
        return results;
    }

    public static List<Coor> getBlackForwardCoors(Coor coor) {
        List<Coor> results = new ArrayList<>();
        if (coor.getX() + 1 < Params.MAX_ROW && coor.getY() - 1 >= 0) {
            results.add(new Coor(coor.getX() + 1, coor.getY() - 1));
        }
        if (coor.getX() + 1 < Params.MAX_ROW && coor.getY() + 1 < Params.MAX_COL) {
            results.add(new Coor(coor.getX() + 1, coor.getY() + 1));
        }
        return results;
    }

    public static List<Coor> getRedBackwardCoors(Coor coor) {
        return getBlackForwardCoors(coor);
    }

    public static List<Coor> getBlackBackwardCoors(Coor coor) {
        return getRedForwardCoors(coor);
    }

    public static List<Pair<Coor, Coor>> getTwoRedForwardCoors(Coor coor) {
        List<Pair<Coor, Coor>> results = new ArrayList<>();
        if (coor.getX() - 2 >= 0 && coor.getY() - 2 >= 0) {
            Coor coor1 = new Coor(coor.getX() - 1, coor.getY() - 1);
            Coor coor2 = new Coor(coor.getX() - 2, coor.getY() - 2);
            results.add(new Pair<>(coor1, coor2));
        }
        if (coor.getX() - 2 >= 0 && coor.getY() + 2 < Params.MAX_COL) {
            Coor coor1 = new Coor(coor.getX() - 1, coor.getY() + 1);
            Coor coor2 = new Coor(coor.getX() - 2, coor.getY() + 2);
            results.add(new Pair<>(coor1, coor2));
        }
        return results;
    }

    public static List<Pair<Coor, Coor>> getTwoBlackForwardCoors(Coor coor) {
        List<Pair<Coor, Coor>> results = new ArrayList<>();
        if (coor.getX() + 2 < Params.MAX_ROW && coor.getY() - 2 >= 0) {
            Coor coor1 = new Coor(coor.getX() + 1, coor.getY() - 1);
            Coor coor2 = new Coor(coor.getX() + 2, coor.getY() - 2);
            results.add(new Pair<>(coor1, coor2));
        }
        if (coor.getX() + 2 < Params.MAX_ROW && coor.getY() + 2 < Params.MAX_COL) {
            Coor coor1 = new Coor(coor.getX() + 1, coor.getY() + 1);
            Coor coor2 = new Coor(coor.getX() + 2, coor.getY() + 2);
            results.add(new Pair<>(coor1, coor2));
        }
        return results;
    }

    public static List<Pair<Coor, Coor>> getTwoBlackBackwardCoors(Coor coor) {
        return getTwoRedForwardCoors(coor);
    }

    public static List<Pair<Coor, Coor>> getTwoRedBackwardCoors(Coor coor) {
        return getTwoBlackForwardCoors(coor);
    }

    /**
     *
     * TEST CODE
     */
    public static void main(String[] args) {

    }
}