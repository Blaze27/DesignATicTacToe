package models;


import enums.PlayerType;

public class Player {
    private String name;
    private Character symbol;
    private PlayerType playerType;

    public Player(String name, Character symbol, PlayerType playerType) {
        setName(name);
        setSymbol(symbol);
        this.playerType = playerType;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Character getSymbol() {
        return symbol;
    }
    public void setSymbol(Character symbol) {
        this.symbol = symbol;
    }
    public PlayerType getPlayerType() {
        return playerType;
    }
    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }
}
