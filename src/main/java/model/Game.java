package model;

import model.board.Board;
import model.piece.Bishop;
import model.piece.King;
import model.piece.Knight;
import model.piece.Pawn;
import model.piece.Piece;
import model.piece.Queen;
import model.piece.Rook;
import model.player.Player;

/**Classe définissant l'ensemble des méthodes du modèle abstrait*/
public class Game extends AbstractModel {
    private Board board;
    private Player whitePlayer;
    private Player blackPlayer;
    private Piece.Side turn;

    public Game() {
        //whitePlayer = new Player(Side.WHITE, true);
        //blackPlayer = new Player(Side.BLACK, false);
        //board = new Board();
        //turn = Piece.Side.WHITE;
    }

    @Override
    public void startNewGame(Player whitePlayer) {
        this.whitePlayer = whitePlayer;
        board = new Board();
        turn = Piece.Side.WHITE;
        
        notifyBoardObserver(board);
    }

    @Override
    public void startNewGame(Player whitePlayer, Player blackPlayer) {
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        board = new Board();
        turn = Piece.Side.WHITE;
        
       notifyBoardObserver(board); 
    }
    
    @Override
     public void makeTurn() {
        //Check victory
         
        //make the move
         
        //change the side color
        this.changeSideColor();
         
        notifyBoardObserver(board);
     }
     
    private void changeSideColor() {
        if(turn == Piece.Side.WHITE) {
            turn = Piece.Side.BLACK;
            whitePlayer.setTurn(false);
            blackPlayer.setTurn(true);
        }
        else {
            turn = Piece.Side.WHITE;
            whitePlayer.setTurn(true);
            blackPlayer.setTurn(false);
        }
    }
    
    @Override
    public Piece selectBoardPiece(Position pos) {
        if(board.getPiece(pos) instanceof Pawn || board.getPiece(pos) instanceof Rook || board.getPiece(pos) instanceof Knight ||
                board.getPiece(pos) instanceof Bishop || board.getPiece(pos) instanceof Queen || board.getPiece(pos) instanceof King)
            return board.getPiece(pos);
        else
            return null;
    }
    
    @Override
    public MoveList getSelectedPieceMoveList(Piece selectedPiece) {
        return selectedPiece.getMoveList(board);
    }
}
