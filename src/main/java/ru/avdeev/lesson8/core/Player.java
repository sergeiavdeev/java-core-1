package ru.avdeev.lesson8.core;

public enum Player {
    PLAYER_X (0, 'X'),
    PLAYER_O (1, 'O'),
    EMPTY (-1, '•');

    private final int value;
    private final char symbol;

    Player(int value, char symbol) {
        this.value = value;
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "" + symbol;
    }

    public int value() {
        return value;
    }
}
