import java.util.List;

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
        List<Pair<Coor, Coor>> coors = Coor.getTwoBlackForwardCoors(this.coor);
        for (Pair<Coor, Coor> pair : coors) {
            if (board.getPieceAt(pair.x) instanceof RedPiece || board.getPieceAt(pair.x) instanceof RedKingPiece) {
                if (board.getPieceAt(pair.y) == null) {
                    return true;
                }
            }
        }
        return false;
    }
}
