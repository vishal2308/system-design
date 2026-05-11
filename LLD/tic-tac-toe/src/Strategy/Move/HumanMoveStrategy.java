package src.Strategy.Move;
import src.Resources.*;

public class HumanMoveStrategy implements MoveStrategy {

    @Override
    public Move createMove(Player player, int row, int col) {
        return new Move(player, row, col);
    }
}