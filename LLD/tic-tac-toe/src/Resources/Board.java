package src.Resources;

public class Board {
    public int size;
    public Cell[][] grid;

    public Board (int size) {
        this.size = size;
        grid = new Cell[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = new Cell(i, j);
            }
        }
    }

    public boolean placeMove (Move move) {
        int row = move.getRow();
        int col = move.getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        if (row < 0 || row >= size || col < 0 || col >= size) return false;

        Cell cell = grid[row][col];
        return cell.occupy(symbol);
    }

    public void printBoard() {
        for (int i = 0 ; i < size; i++) {
            for (int j = 0 ; j < size; j++) {
                String symbol = (grid[i][j].isEmpty()) ? "*" : grid[i][j].getSymbol().toString();
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public void setGrid(Cell[][] grid) {
        this.grid = grid;
    }
}