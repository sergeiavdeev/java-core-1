package ru.avdeev.lesson2;

public class HomeWorkApp {

    private static final int MIN = 10;
    private static final int MAX = 20;

    public static void main(String[] args) {

        System.out.println(checkSumBetween(10, 10));
        getNumberSign(-5);
        System.out.println(isNumberNegative(5));
        printTextLoop("Text loop", 5);
        System.out.println(isYearLeap(2000));
    }

    public static boolean checkSumBetween(int a, int b) {

        int sum = a + b;
        boolean result = false;

        if (sum >= MIN && sum <= MAX) {
            result = true;
        }
        return result;
    }

    public static void getNumberSign(int number) {

        String textSign = "положительное";

        if (number < 0) {
            textSign = "отрицательное";
        }
        System.out.printf("Число: %d %s.%n", number, textSign);
    }

    public static boolean isNumberNegative(int number) {

        boolean result = false;

        if (number < 0) {
            result = true;
        }
        return result;
    }

    public static void printTextLoop(String text, int count) {

        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }

    public static boolean isYearLeap(int year) {

        boolean result = false;

        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            result = true;
        }
        return result;
    }


}
