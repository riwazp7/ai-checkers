import java.util.LinkedList;

/**
 * Created by Riwaz on 2/21/17.
 */
public class Move {

    int pos;
    LinkedList<Coor> coors;
    Piece piece;

    public Move(LinkedList<Coor> coors, Piece piece) {
        this.coors = coors;
        this.piece = piece;
        reset();
    }

    public void reset() {
        pos = 0;
    }

    public Coor nextCoor() {
        pos += 1;
        return coors.get(pos);
    }

    public void add(Coor coor) {
        coors.add(coor);
        reset();
    }

}
