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
        return false;
    }

}
