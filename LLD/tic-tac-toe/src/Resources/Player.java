package src.Resources;

import src.Strategy.Move.MoveStrategy;

public class Player {
    String name;
    Symbol symbol;
    MoveStrategy moveStrategy;

    public Player(Symbol symbol, String name, MoveStrategy moveStrategy) {
        this.symbol = symbol;
        this.name = name;
        this.moveStrategy = moveStrategy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public MoveStrategy getMoveStrategy() {
        return moveStrategy;
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }
}