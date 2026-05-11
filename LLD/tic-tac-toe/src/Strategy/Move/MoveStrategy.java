package src.Strategy.Move;
import src.Resources.*;

public interface MoveStrategy {
    Move createMove(Player player, int row, int col);
}