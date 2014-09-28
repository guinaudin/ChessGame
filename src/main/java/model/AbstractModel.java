package model;

import model.player.Player;

public abstract class AbstractModel {
    public abstract void startNewGame(Player whitePlayer);

    public abstract void startNewGame(Player whitePlayer, Player blackPlayer);
}
