package model.board;

import model.Position;
import model.piece.Bishop;
import model.piece.King;
import model.piece.Knight;
import model.piece.Pawn;
import model.piece.Piece;
import model.piece.Queen;
import model.piece.Rook;

public class Board {
    private Piece[][] board;
    
    public Board() {
        this.initializeDefaultBoard();
    }
    
    public void initializeDefaultBoard() {
        this.board = new Piece[8][8];
        
        board[ColumnTypes.Column.A.getInt()][0] = new Rook(Piece.Side.WHITE);
        board[ColumnTypes.Column.B.getInt()][0] = new Knight(Piece.Side.WHITE);
        board[ColumnTypes.Column.C.getInt()][0] = new Bishop(Piece.Side.WHITE);
        board[ColumnTypes.Column.D.getInt()][0] = new King(Piece.Side.WHITE);
        board[ColumnTypes.Column.E.getInt()][0] = new Queen(Piece.Side.WHITE);
        board[ColumnTypes.Column.F.getInt()][0] = new Bishop(Piece.Side.WHITE);
        board[ColumnTypes.Column.G.getInt()][0] = new Knight(Piece.Side.WHITE);
        board[ColumnTypes.Column.H.getInt()][0] = new Rook(Piece.Side.WHITE);
        
        board[ColumnTypes.Column.A.getInt()][1] = new Pawn(Piece.Side.WHITE);
        board[ColumnTypes.Column.B.getInt()][1] = new Pawn(Piece.Side.WHITE);
        board[ColumnTypes.Column.C.getInt()][1] = new Pawn(Piece.Side.WHITE);
        board[ColumnTypes.Column.D.getInt()][1] = new Pawn(Piece.Side.WHITE);
        board[ColumnTypes.Column.E.getInt()][1] = new Pawn(Piece.Side.WHITE);
        board[ColumnTypes.Column.F.getInt()][1] = new Pawn(Piece.Side.WHITE);
        board[ColumnTypes.Column.G.getInt()][1] = new Pawn(Piece.Side.WHITE);
        board[ColumnTypes.Column.H.getInt()][1] = new Pawn(Piece.Side.WHITE);
        
        board[ColumnTypes.Column.A.getInt()][6] = new Pawn(Piece.Side.BLACK);
        board[ColumnTypes.Column.B.getInt()][6] = new Pawn(Piece.Side.BLACK);
        board[ColumnTypes.Column.C.getInt()][6] = new Pawn(Piece.Side.BLACK);
        board[ColumnTypes.Column.D.getInt()][6] = new Pawn(Piece.Side.BLACK);
        board[ColumnTypes.Column.E.getInt()][6] = new Pawn(Piece.Side.BLACK);
        board[ColumnTypes.Column.F.getInt()][6] = new Pawn(Piece.Side.BLACK);
        board[ColumnTypes.Column.G.getInt()][6] = new Pawn(Piece.Side.BLACK);
        board[ColumnTypes.Column.H.getInt()][6] = new Pawn(Piece.Side.BLACK);
        
        board[ColumnTypes.Column.A.getInt()][7] = new Rook(Piece.Side.BLACK);
        board[ColumnTypes.Column.B.getInt()][7] = new Knight(Piece.Side.BLACK);
        board[ColumnTypes.Column.C.getInt()][7] = new Bishop(Piece.Side.BLACK);
        board[ColumnTypes.Column.D.getInt()][7] = new Queen(Piece.Side.BLACK);
        board[ColumnTypes.Column.E.getInt()][7] = new King(Piece.Side.BLACK);
        board[ColumnTypes.Column.F.getInt()][7] = new Bishop(Piece.Side.BLACK);
        board[ColumnTypes.Column.G.getInt()][7] = new Knight(Piece.Side.BLACK);
        board[ColumnTypes.Column.H.getInt()][7] = new Rook(Piece.Side.BLACK);
    }
    
    public Piece getPiece(Position position) {
        return board[position.getX()][position.getY()];
    }
    
    public boolean inRange(Position position) {
        return (position.getX() > 0) && (position.getY() > 0) &&
               (position.getX() <= 8) && (position.getY() <= 8);
    }
    
    public boolean isEmpty(Position position) {
        return getPiece(position) == null;
    }
    
    public boolean isEmpty(Position position, Piece.Side side) {
        Piece piece = getPiece(position);
        if (piece == null) {
            return true;
        }
        return piece.getSide() != side;
    }
    
    public boolean isFree(Position position) {
        return inRange(position) && isEmpty(position);
    }
    
    public boolean isFree(Position position, Piece.Side side) {
        return inRange(position) && isEmpty(position, side);
    }
}
