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
        
        board[ColumnTypes.Column.A.getInt()][LineTypes.Line.EIGHT.getInt()] = new Rook(new Position(ColumnTypes.Column.A.getInt(), LineTypes.Line.EIGHT.getInt()), Piece.Side.WHITE);
        board[ColumnTypes.Column.B.getInt()][LineTypes.Line.EIGHT.getInt()] = new Knight(new Position(ColumnTypes.Column.B.getInt(), LineTypes.Line.EIGHT.getInt()), Piece.Side.WHITE);
        board[ColumnTypes.Column.C.getInt()][LineTypes.Line.EIGHT.getInt()] = new Bishop(new Position(ColumnTypes.Column.C.getInt(), LineTypes.Line.EIGHT.getInt()), Piece.Side.WHITE);
        board[ColumnTypes.Column.D.getInt()][LineTypes.Line.EIGHT.getInt()] = new Queen(new Position(ColumnTypes.Column.D.getInt(), LineTypes.Line.EIGHT.getInt()), Piece.Side.WHITE);
        board[ColumnTypes.Column.E.getInt()][LineTypes.Line.EIGHT.getInt()] = new King(new Position(ColumnTypes.Column.E.getInt(), LineTypes.Line.EIGHT.getInt()), Piece.Side.WHITE);
        board[ColumnTypes.Column.F.getInt()][LineTypes.Line.FOUR.getInt()] = new Bishop(new Position(ColumnTypes.Column.F.getInt(), LineTypes.Line.FOUR.getInt()), Piece.Side.WHITE);
        board[ColumnTypes.Column.G.getInt()][LineTypes.Line.FIVE.getInt()] = new Knight(new Position(ColumnTypes.Column.G.getInt(), LineTypes.Line.FIVE.getInt()), Piece.Side.WHITE);
        board[ColumnTypes.Column.H.getInt()][LineTypes.Line.SIX.getInt()] = new Rook(new Position(ColumnTypes.Column.H.getInt(), LineTypes.Line.SIX.getInt()), Piece.Side.WHITE);
        
        board[ColumnTypes.Column.A.getInt()][LineTypes.Line.SEVEN.getInt()] = new Pawn(new Position(ColumnTypes.Column.A.getInt(), LineTypes.Line.SEVEN.getInt()), Piece.Side.WHITE);
        board[ColumnTypes.Column.B.getInt()][LineTypes.Line.SEVEN.getInt()] = new Pawn(new Position(ColumnTypes.Column.B.getInt(), LineTypes.Line.SEVEN.getInt()), Piece.Side.WHITE);
        board[ColumnTypes.Column.C.getInt()][LineTypes.Line.SIX.getInt()] = new Pawn(new Position(ColumnTypes.Column.C.getInt(), LineTypes.Line.SIX.getInt()), Piece.Side.WHITE);
        board[ColumnTypes.Column.D.getInt()][LineTypes.Line.SEVEN.getInt()] = new Pawn(new Position(ColumnTypes.Column.D.getInt(), LineTypes.Line.SEVEN.getInt()), Piece.Side.WHITE);
        board[ColumnTypes.Column.E.getInt()][LineTypes.Line.SEVEN.getInt()] = new Pawn(new Position(ColumnTypes.Column.E.getInt(), LineTypes.Line.SEVEN.getInt()), Piece.Side.WHITE);
        board[ColumnTypes.Column.F.getInt()][LineTypes.Line.SEVEN.getInt()] = new Pawn(new Position(ColumnTypes.Column.F.getInt(), LineTypes.Line.SEVEN.getInt()), Piece.Side.WHITE);
        board[ColumnTypes.Column.G.getInt()][LineTypes.Line.SEVEN.getInt()] = new Pawn(new Position(ColumnTypes.Column.G.getInt(), LineTypes.Line.SEVEN.getInt()), Piece.Side.WHITE);
        board[ColumnTypes.Column.H.getInt()][LineTypes.Line.SEVEN.getInt()] = new Pawn(new Position(ColumnTypes.Column.H.getInt(), LineTypes.Line.SEVEN.getInt()), Piece.Side.WHITE);
        
        board[ColumnTypes.Column.A.getInt()][LineTypes.Line.ONE.getInt()] = new Rook(new Position(ColumnTypes.Column.A.getInt(), LineTypes.Line.ONE.getInt()), Piece.Side.BLACK);
        board[ColumnTypes.Column.B.getInt()][LineTypes.Line.ONE.getInt()] = new Knight(new Position(ColumnTypes.Column.B.getInt(), LineTypes.Line.ONE.getInt()), Piece.Side.BLACK);
        board[ColumnTypes.Column.C.getInt()][LineTypes.Line.ONE.getInt()] = new Bishop(new Position(ColumnTypes.Column.C.getInt(), LineTypes.Line.ONE.getInt()), Piece.Side.BLACK);
        board[ColumnTypes.Column.D.getInt()][LineTypes.Line.ONE.getInt()] = new Queen(new Position(ColumnTypes.Column.D.getInt(), LineTypes.Line.ONE.getInt()), Piece.Side.BLACK);
        board[ColumnTypes.Column.E.getInt()][LineTypes.Line.ONE.getInt()] = new King(new Position(ColumnTypes.Column.E.getInt(), LineTypes.Line.ONE.getInt()), Piece.Side.BLACK);
        board[ColumnTypes.Column.F.getInt()][LineTypes.Line.ONE.getInt()] = new Bishop(new Position(ColumnTypes.Column.F.getInt(), LineTypes.Line.ONE.getInt()), Piece.Side.BLACK);
        board[ColumnTypes.Column.G.getInt()][LineTypes.Line.ONE.getInt()] = new Knight(new Position(ColumnTypes.Column.G.getInt(), LineTypes.Line.ONE.getInt()), Piece.Side.BLACK);
        board[ColumnTypes.Column.H.getInt()][LineTypes.Line.ONE.getInt()] = new Rook(new Position(ColumnTypes.Column.H.getInt(), LineTypes.Line.ONE.getInt()), Piece.Side.BLACK);
        
        board[ColumnTypes.Column.A.getInt()][LineTypes.Line.SIX.getInt()] = new Pawn(new Position(ColumnTypes.Column.A.getInt(), LineTypes.Line.SIX.getInt()), Piece.Side.BLACK);
        board[ColumnTypes.Column.B.getInt()][LineTypes.Line.FIVE.getInt()] = new Pawn(new Position(ColumnTypes.Column.B.getInt(), LineTypes.Line.FIVE.getInt()), Piece.Side.BLACK);
        board[ColumnTypes.Column.C.getInt()][LineTypes.Line.FOUR.getInt()] = new Pawn(new Position(ColumnTypes.Column.C.getInt(), LineTypes.Line.FOUR.getInt()), Piece.Side.BLACK);
        board[ColumnTypes.Column.D.getInt()][LineTypes.Line.FIVE.getInt()] = new Pawn(new Position(ColumnTypes.Column.D.getInt(), LineTypes.Line.FIVE.getInt()), Piece.Side.BLACK);
        board[ColumnTypes.Column.E.getInt()][LineTypes.Line.TWO.getInt()] = new Pawn(new Position(ColumnTypes.Column.E.getInt(), LineTypes.Line.TWO.getInt()), Piece.Side.BLACK);
        board[ColumnTypes.Column.F.getInt()][LineTypes.Line.TWO.getInt()] = new Pawn(new Position(ColumnTypes.Column.F.getInt(), LineTypes.Line.TWO.getInt()), Piece.Side.BLACK);
        board[ColumnTypes.Column.G.getInt()][LineTypes.Line.TWO.getInt()] = new Pawn(new Position(ColumnTypes.Column.G.getInt(), LineTypes.Line.TWO.getInt()), Piece.Side.BLACK);
        board[ColumnTypes.Column.H.getInt()][LineTypes.Line.TWO.getInt()] = new Pawn(new Position(ColumnTypes.Column.H.getInt(), LineTypes.Line.TWO.getInt()), Piece.Side.BLACK);
    }
    
    public Piece[][] getBoard() {
        return board;
    }
    
    public Piece getPiece(Position position) {
        return board[position.getX()][position.getY()];
    }
    
    public boolean inRange(Position position) {
        return (position.getX() >= 0) && (position.getY() >= 0) &&
               (position.getX() < 8) && (position.getY() < 8);
    }
    
    public boolean isEmpty(Position position) {
        return getPiece(position) == null;
    }
    
    public boolean isEmpty(Position position, Piece.Side side) {
        Piece piece = this.getPiece(position);
        
        if (piece == null) {
            System.out.println("test");
            return true;
        }
        return piece.getSide() != side;
    }
    
    public boolean isFree(Position position) {
        if(this.inRange(position))
            return this.isEmpty(position);
        else
            return false;
    }
    
    public boolean isFree(Position position, Piece.Side side) {
        if(this.inRange(position)) 
            return this.isEmpty(position, side);
        else
            return false;
    }
}
