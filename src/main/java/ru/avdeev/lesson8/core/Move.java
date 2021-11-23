package ru.avdeev.lesson8.core;

public class Move {

    private int x;
    private int y;
    private final int score;
    private Player player = Player.EMPTY;

    public Move(int x, int y, int score) {
        this.x = x;
        this.y = y;
        this.score = score;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getScore() {
        return score;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
