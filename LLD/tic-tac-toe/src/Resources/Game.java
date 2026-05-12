package src.Resources;

import src.Exceptions.InvalidMoveException;
import src.Exceptions.InvalidStateException;
import src.Strategy.Win.WinStrategy;

import java.util.*;

public class Game {
    private final Queue<Player> turns;
    private final Board board;
    private final WinStrategy winStrategy;
    private States state;
    private int movesPlayed;

    public Game(List<Player> players, WinStrategy winStrategy, int size) {
        this.winStrategy = winStrategy;
        this.turns = new LinkedList<>(players);
        this.board = new Board(size);
        this.state = States.IN_PROGRESS;
        this.movesPlayed = 0;
    }

    public void play () {
        if (state != States.IN_PROGRESS) {
            throw new InvalidStateException("Game is already over");
        }
        Player current = turns.peek();
        Move move = current.makeMove();
        boolean placedSuccessfully = board.placeMove(move);
        if (!placedSuccessfully) {
            throw new InvalidMoveException("Invalid Move");
        }
        movesPlayed++;
        if (winStrategy.checkWinner(board, move)) {
            state = States.WIN;
            System.out.println("Player "+ current.getName() + " has won");
        } else if (movesPlayed >= board.getSize() * board.getSize()) {
            state = States.DRAW;
            System.out.println("Game is Drawn");
        } else {
            Player nextPlayer = turns.poll();
            turns.offer(nextPlayer);
        }
        board.printBoard();
    }

    public States getState() {
        return state;
    }
}
