package ru.avdeev.lesson1;

public class HomeWorkApp {

    public static void main(String[] args) {

        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    private static void printThreeWords() {

        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    private static void checkSumSign() {

        int a = 5;
        int b = -6;

        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    private static void printColor() {

        int value = 101;

        if (value > 100) {
            System.out.println("Зеленый");
        } else if (value > 0) {
            System.out.println("Желтый");
        } else {
            System.out.println("Красный");
        }
    }

    private static void compareNumbers() {

        int a = 10;
        int b = 10;

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
}
