package src.Resources;

public class Cell {
    int row;
    int col;
    Symbol symbol;

    public Cell(int row, int col) {
        this.col = col;
        this.row = row;
    }

    public boolean isEmpty() {
        return symbol == null;
    }

    public boolean occupy(Symbol symbol) {
        if (!this.isEmpty()) return false;
        this.setSymbol(symbol);
        return true;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}