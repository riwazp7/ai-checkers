import java.util.List;

/**
 * Created by Riwaz on 2/16/17.
 */
public interface PieceInterface {
    int x = -1;
    int y = -1;

    boolean hasToMove();
    List<Move> getPossibleMoves();
}
