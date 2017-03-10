import java.util.List;

/**
 * Created by Riwaz on 2/17/17.
 */
public class RedPiece extends Piece {

    public RedPiece(Board board, RedPiece redPiece) {
        super(board, redPiece);
        isRed = true;
    }

    public boolean hasToMove() {
        List<Pair<Coor, Coor>> coors = Coor.getTwoRedForwardCoors(this.coor);
        for (Pair<Coor, Coor> pair : coors) {
            if (board.getPieceAt(pair.x) instanceof BlackPiece || board.getPieceAt(pair.x) instanceof BlackKingPiece) {
                if (board.getPieceAt(pair.y) == null) {
                    return true;
                }
            }
        }
        return false;
    }
}
