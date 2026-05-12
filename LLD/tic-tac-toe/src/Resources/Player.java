package src.Resources;

import src.Strategy.Move.MoveStrategy;

public class Player {
    private final String name;
    private final Symbol symbol;
    private final MoveStrategy moveStrategy;

    public Player(Symbol symbol, String name, MoveStrategy moveStrategy) {
        this.symbol = symbol;
        this.name = name;
        this.moveStrategy = moveStrategy;
    }

    public Move makeMove() {
        return this.getMoveStrategy().createMove(this);
    }

    public String getName() {
        return name;
    }


    public Symbol getSymbol() {
        return symbol;
    }


    public MoveStrategy getMoveStrategy() {
        return moveStrategy;
    }

}