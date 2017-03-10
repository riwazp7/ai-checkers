/**
 * Created by Riwaz on 2/17/17.
 */
public class BlackPiece extends Piece {

    public BlackPiece(Board board, BlackPiece blackPiece) {
        super(board, blackPiece);
        isRed = false;
    }

    @Override
    public boolean hasToMove() {
        return false;
    }
}
