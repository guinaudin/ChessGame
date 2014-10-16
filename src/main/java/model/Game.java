package model;

import model.board.Board;
import model.piece.Piece.Side;
import model.player.Player;

/**Classe définissant l'ensemble des méthodes du modèle abstrait*/
public class Game extends AbstractModel {
    private Board board;
    private Player whitePlayer;
    private Player blackPlayer;

    public Game() {
        whitePlayer = new Player(Side.WHITE, true);
        blackPlayer = new Player(Side.BLACK, false);
        board = new Board();
    }

    @Override
    public void startNewGame(Player whitePlayer) {
        this.whitePlayer = whitePlayer;
        board = new Board();
    }

    @Override
    public void startNewGame(Player whitePlayer, Player blackPlayer) {
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        board = new Board();
    }
}
