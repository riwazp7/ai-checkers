/**
 * Created by Riwaz on 3/10/17.
 */
public class BlackKingPiece extends RedPiece {

    public BlackKingPiece(RedPiece piece) {
        super(piece.board, piece);
    }

    @Override
    public boolean hasToMove() {
        if (super.hasToMove()) {
            return true;
        }
        return false;
    }

}
