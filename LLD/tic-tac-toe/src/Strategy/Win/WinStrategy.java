package src.Strategy.Win;

import src.Resources.Board;
import src.Resources.Move;

public interface WinStrategy {
    boolean checkWinner(Board board, Move move);
}
