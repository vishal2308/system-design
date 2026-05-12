package src.Resources;

public class Move {
    private final int row;
    private final int col;
    private final Player player;

    public Move(Player player, int row, int col) {
        this.player = player;
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }


    public Player getPlayer() {
        return player;
    }
}