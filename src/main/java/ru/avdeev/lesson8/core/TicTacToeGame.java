package ru.avdeev.lesson8.core;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeGame {

    private final Settings settings;
    private final List<Move> field;
    private Player currentPlayer = Player.PLAYER_X;
    private Player winner = Player.EMPTY;
    private Move lastStepAi;
    private boolean isGameOver = false;

    public TicTacToeGame(Settings settings) {
        this.settings = settings;
        field = new ArrayList<>(settings.fieldSize * settings.fieldSize);
        init();
    }

    private void init() {
        int x = 0;
        int y = 0;
        while (y < settings.fieldSize) {
            field.add(new Move(x, y, -100));
            x ++;
            if (x > settings.fieldSize - 1) {
                x = 0;
                y++;
            }
        }
        lastStepAi = new Move(-1, -1, -100);
    }

    public void nextStep(int x, int y, Player player) {

        Move move = field.get(y * settings.fieldSize + x);
        if (move.getPlayer() == Player.EMPTY) {
            move.setPlayer(player);
            if (checkWin(null, player)) {
                winner = player;
                isGameOver = true;
                return;
            }
        }

        if (settings.mode == Mode.HUMAN_VS_AI) {

            move = minimax(field, Player.PLAYER_O);
            if (move.getX() != -1 && move.getY() != -1) {
                field.get(move.getY() * settings.fieldSize + move.getX()).setPlayer(Player.PLAYER_O);
                lastStepAi.setX(move.getX());
                lastStepAi.setY(move.getY());
            } else {
                isGameOver = true;
            }
            currentPlayer = Player.PLAYER_O;
            if (checkWin(null, Player.PLAYER_O)) {
                winner = Player.PLAYER_O;
                isGameOver = true;
                return;
            }
        }
        currentPlayer = currentPlayer == Player.PLAYER_X ? Player.PLAYER_O : Player.PLAYER_X;
    }

    private List<Move> getAvailableSteps(List<Move> newField) {

        List<Move> available = new ArrayList<>();
        for (Move el : newField) {
            if (el.getPlayer() == Player.EMPTY) {
                available.add(el);
            }
        }
        return available;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getWinner() {
        return winner;
    }

    private boolean checkWin(List<Move> newField, Player player) {

        List<Move> checkField = field;

        if (newField != null) {
            checkField = newField;
        }

        for (int i = 0; i < settings.fieldSize; i++) {

            if (checkLine(0, i, 1, 0, checkField, player)) return true;
            if (checkLine(i, 0, 0, 1, checkField, player)) return true;
        }

        int x = 0, x1 = 0;
        int y = settings.fieldSize - settings.winLength, y1 = settings.winLength - 1;

        while (x <= settings.fieldSize - settings.winLength) {
            if (checkLine(x, y, 1, 1, checkField, player))return true;
            if (checkLine(x1, y1, 1, -1, checkField, player))return true;
            y--;
            if (y < 0) {
                y = 0;
                x++;
            }
            y1++;
            if (y1 > settings.fieldSize - 1) {
                y1 = settings.fieldSize - 1;
                x1++;
            }
        }

        return false;
    }

    private boolean checkLine(int startX, int startY, int dx, int dy, List<Move> newField, Player player) {

        int charCount = 0;

        for (int i = 0; i < settings.fieldSize; i++) {

            int testX = startX + i * dx;
            int testY = startY + i * dy;
            int index = testX + testY * settings.fieldSize;

            if (index < 0 || index >= newField.size())continue;

            if (newField.get(index).getPlayer() == player) {
                charCount ++;
            } else {
                charCount = 0;
            }

            if (charCount == settings.winLength)return true;
        }
        return false;
    }

    private Move minimax(List<Move> newField, Player player) {

        List<Move> availableSteps = getAvailableSteps(newField);
        List<Move> moves = new ArrayList<>(availableSteps.size());
        Move bestMove;

        //System.out.println("Доступно ходов: " + availableSteps.size());

        if (checkWin(newField, Player.PLAYER_X)) {
            return new Move(-1, -1, -10);
        } else if(checkWin(newField, Player.PLAYER_O)) {
            return new Move(-1, -1, 10);
        } else if (availableSteps.size() == 0) {
            return new Move(-1, -1, 0);
        }

        int maxScore = -10000, minScore = 10000;

        for (Move availableStep : availableSteps) {

            availableStep.setPlayer(player);
            Move move;
            if (player == Player.PLAYER_O) {
                move = minimax(newField, Player.PLAYER_X);
                maxScore = Math.max(maxScore, move.getScore());
                if (maxScore == 10) {
                    availableStep.setPlayer(Player.EMPTY);
                    return new Move(availableStep.getX(), availableStep.getY(), move.getScore());
                }
            }  else {
                move = minimax(newField, Player.PLAYER_O);
                minScore = Math.min(minScore, move.getScore());
                if (minScore == -10) {
                    availableStep.setPlayer(Player.EMPTY);
                    return new Move(availableStep.getX(), availableStep.getY(), move.getScore());
                }
            }

            availableStep.setPlayer(Player.EMPTY);
            moves.add(new Move(availableStep.getX(), availableStep.getY(), move.getScore()));
        }


        bestMove = new Move(-1, -1, -100);
        if (player == Player.PLAYER_O) {
            int bestScore = - 10000;
            for (Move el : moves) {
                if (el.getScore() > bestScore) {
                    bestMove = el;
                    bestScore = el.getScore();
                    if (bestScore >=10)break;
                }
            }
        } else {
            int bestScore = 10000;
            for (Move el : moves) {
                if (el.getScore() < bestScore) {
                    bestMove = el;
                    bestScore = el.getScore();
                    if (bestScore <= -10)break;
                }
            }
        }

        return bestMove;
    }

    public Move getLastStepAi() {
        return lastStepAi;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    @Override
    public String toString() {

        return """
                TicTacToeGame{
                field:
                }""";
    }
}
