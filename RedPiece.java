/**
 * Created by Riwaz on 2/17/17.
 */
public class RedPiece extends Piece {

    public RedPiece(Board board, RedPiece redPiece) {
        super(board, redPiece);
        isRed = true;
    }

    public boolean hasToMove() {
        return false;
    }
}
