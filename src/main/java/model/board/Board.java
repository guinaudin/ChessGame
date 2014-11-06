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
    
    private void initializeDefaultBoard() {
        this.board = new Piece[8][8];
        
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                board[i][j] = null;
            }
        }
        
        board[LineTypes.Line.ONE.getInt()][ColumnTypes.Column.A.getInt()] = new Rook(Piece.Side.WHITE);
        board[LineTypes.Line.ONE.getInt()][ColumnTypes.Column.B.getInt()] = new Knight(Piece.Side.WHITE);
        board[LineTypes.Line.ONE.getInt()][ColumnTypes.Column.C.getInt()] = new Bishop(Piece.Side.WHITE);
        board[LineTypes.Line.ONE.getInt()][ColumnTypes.Column.D.getInt()] = new Queen(Piece.Side.WHITE);
        board[LineTypes.Line.ONE.getInt()][ColumnTypes.Column.E.getInt()] = new King(Piece.Side.WHITE);
        board[LineTypes.Line.ONE.getInt()][ColumnTypes.Column.F.getInt()] = new Bishop(Piece.Side.WHITE);
        board[LineTypes.Line.ONE.getInt()][ColumnTypes.Column.G.getInt()] = new Knight(Piece.Side.WHITE);
        board[LineTypes.Line.ONE.getInt()][ColumnTypes.Column.H.getInt()] = new Rook(Piece.Side.WHITE);
        
        board[LineTypes.Line.TWO.getInt()][ColumnTypes.Column.A.getInt()] = new Pawn(Piece.Side.WHITE);
        board[LineTypes.Line.TWO.getInt()][ColumnTypes.Column.B.getInt()] = new Pawn(Piece.Side.WHITE);
        board[LineTypes.Line.TWO.getInt()][ColumnTypes.Column.C.getInt()] = new Pawn(Piece.Side.WHITE);
        board[LineTypes.Line.TWO.getInt()][ColumnTypes.Column.D.getInt()] = new Pawn(Piece.Side.WHITE);
        board[LineTypes.Line.TWO.getInt()][ColumnTypes.Column.E.getInt()] = new Pawn(Piece.Side.WHITE);
        board[LineTypes.Line.TWO.getInt()][ColumnTypes.Column.F.getInt()] = new Pawn(Piece.Side.WHITE);
        board[LineTypes.Line.TWO.getInt()][ColumnTypes.Column.G.getInt()] = new Pawn(Piece.Side.WHITE);
        board[LineTypes.Line.TWO.getInt()][ColumnTypes.Column.H.getInt()] = new Pawn(Piece.Side.WHITE);
        
        board[LineTypes.Line.SEVEN.getInt()][ColumnTypes.Column.A.getInt()] = new Pawn(Piece.Side.BLACK);
        board[LineTypes.Line.SEVEN.getInt()][ColumnTypes.Column.B.getInt()] = new Pawn(Piece.Side.BLACK);
        board[LineTypes.Line.SEVEN.getInt()][ColumnTypes.Column.C.getInt()] = new Pawn(Piece.Side.BLACK);
        board[LineTypes.Line.SEVEN.getInt()][ColumnTypes.Column.D.getInt()] = new Pawn(Piece.Side.BLACK);
        board[LineTypes.Line.SEVEN.getInt()][ColumnTypes.Column.E.getInt()] = new Pawn(Piece.Side.BLACK);
        board[LineTypes.Line.SEVEN.getInt()][ColumnTypes.Column.F.getInt()] = new Pawn(Piece.Side.BLACK);
        board[LineTypes.Line.SEVEN.getInt()][ColumnTypes.Column.G.getInt()] = new Pawn(Piece.Side.BLACK);
        board[LineTypes.Line.SEVEN.getInt()][ColumnTypes.Column.H.getInt()] = new Pawn(Piece.Side.BLACK);
        
        board[LineTypes.Line.EIGHT.getInt()][ColumnTypes.Column.A.getInt()] = new Rook(Piece.Side.BLACK);
        board[LineTypes.Line.EIGHT.getInt()][ColumnTypes.Column.B.getInt()] = new Knight(Piece.Side.BLACK);
        board[LineTypes.Line.EIGHT.getInt()][ColumnTypes.Column.C.getInt()] = new Bishop(Piece.Side.BLACK);
        board[LineTypes.Line.EIGHT.getInt()][ColumnTypes.Column.D.getInt()] = new Queen(Piece.Side.BLACK);
        board[LineTypes.Line.EIGHT.getInt()][ColumnTypes.Column.E.getInt()] = new King(Piece.Side.BLACK);
        board[LineTypes.Line.EIGHT.getInt()][ColumnTypes.Column.F.getInt()] = new Bishop(Piece.Side.BLACK);
        board[LineTypes.Line.EIGHT.getInt()][ColumnTypes.Column.G.getInt()] = new Knight(Piece.Side.BLACK);
        board[LineTypes.Line.EIGHT.getInt()][ColumnTypes.Column.H.getInt()] = new Rook(Piece.Side.BLACK);
    }
    
    public Piece[][] getBoard() {
        return board;
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
