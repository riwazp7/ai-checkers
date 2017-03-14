import java.util.ArrayList;
import java.util.List;

/**
 * Created by Riwaz on 3/10/17.
 */
public class RedKingPiece extends RedPiece {

    public RedKingPiece(RedPiece piece) {
        super(piece.board, piece);
        super.makeKing();
    }

    @Override
    public boolean hasToMove() {
        if (super.hasToMove()) {
            return true;
        }
        List<Pair<Coor, Coor>> coors = Coor.getTwoRedBackwardCoors(this.coor);
        for (Pair<Coor, Coor> pair : coors) {
            if (board.getPieceAt(pair.x) instanceof BlackPiece || board.getPieceAt(pair.x) instanceof BlackKingPiece) {
                if (board.getPieceAt(pair.y) == null) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<Move> getPossibleMoves() {
        List<Move> results = new ArrayList<>();
        results.addAll(super.getPossibleMoves());
        return results;
    }
}
