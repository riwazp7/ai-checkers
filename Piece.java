/**
 * Created by Riwaz on 2/16/17.
 */
public class Piece implements PieceInterface {

    protected Board board;
    protected Coor coor;

    public Piece(Board board, Coor coor) {
        this.board = board;
        this.coor = coor;
    }

    public Piece(Board board, Piece piece) {
        this.board = board;
        this.coor = piece.getCoor();
    }

    public Coor getCoor() {
        return this.coor;
    }

    public Board getBoard() {
        return this.board;
    }
}
