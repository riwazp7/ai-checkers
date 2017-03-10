/**
 * Created by Riwaz on 2/16/17.
 */
public abstract class Piece implements PieceInterface {

    protected Board board;
    protected Coor coor;
    protected boolean isKing = false;
    protected boolean isRed;

    public Piece(Board board, Coor coor) {
        this.board = board;
        this.coor = coor;
    }

    public Piece(Board board, Piece piece) {
        this.board = board;
        this.coor = piece.getCoor();
        if (piece.isKing()) {
            this.makeKing();
        }
    }

    public void makeKing() {
        this.isKing = true;
    }

    public boolean isKing() {
        return isKing;
    }

    public Coor getCoor() {
        return this.coor;
    }

    public Board getBoard() {
        return this.board;
    }

    abstract public boolean hasToMove();
}
