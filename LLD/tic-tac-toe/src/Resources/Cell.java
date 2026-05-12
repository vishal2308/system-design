package src.Resources;

public class Cell {
    private final int row;
    private final int col;
    private Symbol symbol;

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


    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}