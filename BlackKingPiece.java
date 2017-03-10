import java.util.List;

/**
 * Created by Riwaz on 3/10/17.
 */
public class BlackKingPiece extends BlackPiece {

    public BlackKingPiece(BlackPiece piece) {
        super(piece.board, piece);
        super.makeKing();
    }

    @Override
    public boolean hasToMove() {
        if (super.hasToMove()) {
            return true;
        }
        List<Pair<Coor, Coor>> coors = Coor.getTwoBlackBackwardCoors(this.coor);
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
