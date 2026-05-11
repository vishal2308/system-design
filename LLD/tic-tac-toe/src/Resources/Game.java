package src.Resources;

import src.Strategy.Win.WinStrategy;

import java.util.*;

public class Game {
    List<Player> players;
    Queue<Player> turns;
    Board board;
    States state;
    WinStrategy winStrategy;
    int movesPlayed;

    public Game(List<Player> players, WinStrategy winStrategy, int size) {
        this.players = players;
        this.winStrategy = winStrategy;
        this.turns = new LinkedList<>(players);
        this.board = new Board(size);
        this.state = States.IN_PROGRESS;
        movesPlayed = 0;
    }

    public void makeMove (int row, int col) {
        if (state != States.IN_PROGRESS) {
            throw new RuntimeException("Game is already over");
        }

        Player current = turns.poll();
        Move move = current.getMoveStrategy().createMove(current, row, col);
        boolean placedSuccessfully = board.placeMove(move);
        if (!placedSuccessfully) {
            turns.offer(current);
            throw new RuntimeException("Invalid Move");
        }
        movesPlayed++;
        if (winStrategy.checkWinner(board, move)) {
            state = States.WIN;
            System.out.println("Player "+ current.getName() + " has won");
        } else if (movesPlayed >= board.getSize() * board.getSize()) {
            state = States.DRAW;
            System.out.println("Game is Drawn");
        }
        board.printBoard();
        turns.offer(current);
    }

}
