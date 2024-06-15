package models;

import enums.CellState;

public class Cell {
    private Player player;
    private Integer row;
    private Integer col;
    private CellState cellState;

    public Cell(Integer row, Integer col) {
        this.row = row;
        this.col = col;
        this.cellState = CellState.EMPTY;
    }

    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
    public Integer getRow() {
        return row;
    }
    public void setRow(Integer row) {
        this.row = row;
    }
    public Integer getCol() {
        return col;
    }
    public void setCol(Integer col) {
        this.col = col;
    }
    public CellState getCellState() {
        return cellState;
    }
    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }
}
