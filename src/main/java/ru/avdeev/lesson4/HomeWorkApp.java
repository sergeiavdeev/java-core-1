package ru.avdeev.lesson4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWorkApp {

    private static char[][] map;

    private static final int FIELD_SIZE = 3;
    private static final int DOTS_TO_WIN = 3;

    private static final char DOT_EMPTY = '•';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        initMap();
        printMap();

        boolean isWinner = false;
        int countStep = 0;

        while (countStep < FIELD_SIZE * FIELD_SIZE) {

            countStep++;

            if (countStep % 2 > 0) {

                playerStep();
                if (checkWin(DOT_X)) {
                    System.out.println("Выиграли " + DOT_X);
                    isWinner = true;
                    printMap();
                    break;
                }
            } else {
                compStep();
                if (checkWin(DOT_O)) {
                    System.out.println("Выиграли " + DOT_O);
                    isWinner = true;
                    printMap();
                    break;
                }
                printMap();
            }
        }

        if (!isWinner) System.out.println("Ничья!");
        System.out.println("Игра окончена!");
    }

    private static void initMap() {

        map = new char[FIELD_SIZE][FIELD_SIZE];

        for(char[] row: map) {
            Arrays.fill(row, DOT_EMPTY);
        }
    }

    private static void printMap() {

        for(char[] row : map) {
            for (char col: row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    private static void playerStep () {

        int x, y;
        do {
            System.out.print("Введите ячейку для хода X Y: ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isValidCell(x, y));

        map[y][x] = DOT_X;
    }

    private static boolean isValidCell(int x, int y) {

        return x >= 0 && x < FIELD_SIZE && y >= 0 && y < FIELD_SIZE && map[y][x] == DOT_EMPTY;
    }

    private static void compStep() {

        //Есть ли выигрышные ходы для компа
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (isWinnerStep(i, j, DOT_O)) {
                    map[j][i] = DOT_O;
                    return;
                }
            }
        }

        //Блокируем выигрышные ходы человека
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (isWinnerStep(i, j, DOT_X)) {
                    map[j][i] = DOT_O;
                    return;
                }
            }
        }

        randomStep();
    }

    private static boolean checkWin(char symbol) {

        for (int i = 0; i < FIELD_SIZE; i++) {

            if (checkLine(0, i, 1, 0, symbol)) return true;
            if (checkLine(i, 0, 0, 1, symbol)) return true;
        }

        return checkLine(0, 0, 1, 1, symbol)
                || checkLine(0, FIELD_SIZE - 1, 1, -1, symbol);
    }

    private static boolean checkLine(int startX, int startY, int dx, int dy, char symbol) {

        int charCount = 0;
        for (int i = 0; i < FIELD_SIZE; i++) {

            if (map[startX+ i * dx][startY + i * dy] == symbol) {
                charCount ++;
            } else {
                charCount = 0;
            }

            if (charCount == DOTS_TO_WIN)return true;
        }
        return false;
    }

    private static void randomStep() {

        Random random = new Random();
        int x, y;
        do {
            x = random.nextInt(FIELD_SIZE);
            y = random.nextInt(FIELD_SIZE);
        } while (!isValidCell(x, y));
        map[y][x] = DOT_O;
    }

    private static boolean isWinnerStep(int x, int y, char symbol) {

        if (isValidCell(x, y)) {
            map[y][x] = symbol;
            if (checkWin(symbol)) {
                map[y][x] = DOT_EMPTY;
                return true;
            }
            map[y][x] = DOT_EMPTY;
        }
        return false;
    }
}
