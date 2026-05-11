package src.Strategy.Win;

import src.Resources.Board;
import src.Resources.Move;
import src.Resources.Symbol;

import java.util.HashMap;
import java.util.Map;

public class NormalWinStrategy implements WinStrategy {
    int size;
    private final Map<Symbol, int[]> rows = new HashMap<>();
    private final Map<Symbol, int[]> cols = new HashMap<>();
    private final Map<Symbol, Integer> diag = new HashMap<>();
    private final Map<Symbol, Integer> antiDiag = new HashMap<>();
    public NormalWinStrategy (int size) {
        this.size = size;
    }

    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getRow();
        int col = move.getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        rows.putIfAbsent(symbol, new int[size]);
        cols.putIfAbsent(symbol, new int[size]);
        diag.putIfAbsent(symbol, 0);
        antiDiag.putIfAbsent(symbol, 0);

        rows.get(symbol)[row]++;
        cols.get(symbol)[col]++;
        if (row == col) {
            diag.put(symbol, diag.get(symbol) + 1);
        }

        if (row + col == size - 1) {
            antiDiag.put(symbol, antiDiag.get(symbol) + 1);
        }
        return (rows.get(symbol)[row] == size || cols.get(symbol)[col] == size || diag.get(symbol) == size || antiDiag.get(symbol) == size);
    }
}
