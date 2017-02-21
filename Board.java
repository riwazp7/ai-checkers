import java.util.ArrayList;
import java.util.List;

/**
 * Created by Riwaz on 2/16/17.
 */
public class Board implements BoardInterface {

    Piece[][] boardArr = new Piece[Params.MAX_ROW][Params.MAX_COL];
    List<Piece> redPieces = new ArrayList<>();
    List<Piece> blackPieces = new ArrayList<>();
    boolean redsTurn;

    public Board(Board board) {
        for (Piece piece : board.getRedPieces()) {
            Piece newPiece = new Piece(this, piece);
            redPieces.add(newPiece);
            boardArr[piece.getCoor().getX()][piece.getCoor().getY()] = newPiece;
        }

        for (Piece piece : board.getBlackPieces()) {
            Piece newPiece = new Piece(this, piece);
            blackPieces.add(newPiece);
            boardArr[piece.getCoor().getX()][piece.getCoor().getY()] = newPiece;
        }

        this.redsTurn = board.getTurn();
    }

    public ArrayList<Board> possibleMoves() {
        return null;
    }

    public void removePiece(Coor coor) {
        Piece piece = boardArr[coor.getX()][coor.getY()];
        boardArr[coor.getX()][coor.getY()] = null;
        if (piece instanceof RedPiece) {
            redPieces.remove(piece);
        } else {
            blackPieces.remove(piece);
        }
    }

    public void addPiece(Coor coor, Piece piece) {
        boardArr[coor.getX()][coor.getY()] = piece;
        if (piece instanceof RedPiece) redPieces.add(piece);
        else blackPieces.add(piece);
    }

    public void changeTurn() {
        redsTurn = !redsTurn;
    }

    @Deprecated
    public String[][] board() {
        return null;
    }

    public Piece[][] getBoardArr() {
        return boardArr;
    }

    public List<Piece> getRedPieces() {
        return this.redPieces;
    }

    public List<Piece> getBlackPieces() {
        return this.blackPieces;
    }

    public boolean getTurn() {
        return this.redsTurn;
    }

    public static Board getStartBoard() {
        return null;
    }

    @Override
    public String toString() {
        String res = "";
        for(int i = 0; i < Params.MAX_ROW; i++) {
            for (int j = 0; j < Params.MAX_COL; j++) {
                if (boardArr[i][j] == null ) res += "X";
                else {
                    res += boardArr[i][j].toString();
                }
            }
            res += "\n";
        }
        return res;
    }
}
