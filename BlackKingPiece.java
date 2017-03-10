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
        return false;
    }

}
