import java.util.ArrayList;

/**
 * Created by Riwaz on 2/16/17.
 */
public interface BoardInterface {
    ArrayList<Piece> redPieces = null;
    ArrayList<Piece> blackPieces = null;
    boolean redsTurn = false;

    ArrayList<Board> possibleMoves();
    String[][] board();

}
