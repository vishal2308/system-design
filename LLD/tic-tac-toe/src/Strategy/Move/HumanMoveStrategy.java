package src.Strategy.Move;
import src.Resources.*;

import java.util.Scanner;

public class HumanMoveStrategy implements MoveStrategy {
    private final Scanner scanner;

    public HumanMoveStrategy() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Move createMove(Player player) {
        System.out.print("Enter the row : ");
        int row = scanner.nextInt();
        System.out.print("Enter the col : ");
        int col = scanner.nextInt();
        return new Move(player, row, col);
    }
}