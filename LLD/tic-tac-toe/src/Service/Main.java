package src.Service;

import src.Resources.*;
import src.Strategy.Move.HumanMoveStrategy;
import src.Strategy.Win.NormalWinStrategy;

import java.util.List;

public class Main {

    public static void main (String[] args) {
        Player one = new Player(Symbol.O, "one", new HumanMoveStrategy());
        Player two = new Player(Symbol.X, "two", new HumanMoveStrategy());

        List<Player> players = List.of(one, two);

        Game game = new Game(players, new NormalWinStrategy(3), 3);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                try {
                    game.makeMove(0 , 0);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }

    }
}