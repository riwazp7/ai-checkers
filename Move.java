import java.util.LinkedList;

/**
 * Created by Riwaz on 2/21/17.
 */
public class Move {

    int pos;
    LinkedList<Coor> coors = new LinkedList<>();
    Piece piece;

    public Move(LinkedList<Coor> coors, Piece piece) {
        this.coors = coors;
        this.piece = piece;
        reset();
    }

    public Move(Coor coor, Piece piece) {
        coors.add(coor);
        this.piece = piece;
    }

    public void reset() {
        pos = 0;
    }

    public Coor nextCoor() {
        pos += 1;
        return coors.get(pos - 1);
    }

    public void add(Coor coor) {
        coors.add(coor);
        reset();
    }

    public boolean hasNext() {
        return pos >= coors.size();
    }

    public Piece getPiece() {
        return this.piece;
    }

    public static Board implementMove(Board board, Move move) {
        Coor thisCoor = move.getPiece().getCoor();
        Piece pieceToMove = move.getPiece();
        board.removePiece(thisCoor);
        while(move.hasNext()) {
            Coor nextCoor = move.nextCoor();
            if (!Coor.isDiagonalTo(thisCoor, nextCoor)) {
                Coor mid = Coor.getCenterCoor(thisCoor, nextCoor);
                board.removePiece(mid);
            }
            thisCoor = nextCoor;
        }
        board.addPiece(thisCoor, pieceToMove);
        board.changeTurn();
        return board;
    }

}
