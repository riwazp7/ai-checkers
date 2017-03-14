import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    @Override
    public List<Move> getPossibleMoves() {
        List<Move> result = new ArrayList<>();
        List<Pair<Coor, Coor>> coors = Coor.getTwoBlackForwardCoors(coor);
        if (hasToMove()) {
            Stack<Pair<Coor, Coor>> stack = new Stack();
            for (Pair<Coor, Coor> pair : coors) {
                stack.push(pair);
            }
            while (stack.size() > 0) {
                Pair<Coor, Coor> pair = stack.pop();
                // jk doesn't work need to track path
            }

        } else {
            // simple case :)
            for (Pair<Coor, Coor> pair : coors) {
                if (board.getPieceAt(pair.x) == null) {
                    result.add(new Move(pair.x, this));
                }
            }
        }
        return result;
    }
}
