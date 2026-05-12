package src.Service;

import src.Exceptions.InvalidStateException;
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

        while (game.getState() == States.IN_PROGRESS) {
            try {
                game.play();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}