package ru.avdeev.lesson3;

public class HomeWorkApp {

    public static void main(String[] args) {

        //1
        int[] arr1 = {0, 1, 1, 0, 0, 1};
        arrayPrint(arr1);
        arrayInversion(arr1);
        arrayPrint(arr1);

        //2
        int[] arr2 = new int[100];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i + 1;
        }
        arrayPrint(arr2);

        //3
        int[] arr3 = {5, 6, 8, 4, 9, 3, 1};
        arrayPrint(arr3);
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) arr3[i] *= 2;
        }
        arrayPrint(arr3);

        //4
        int[][] arr4 = new int[5][5];

        for (int i = 0; i < arr4.length; i++) {
            for(int j = 0; j < arr4[i].length; j++) {
                if (i == j || i + j == arr4.length - 1) arr4[i][j] = 1;
            }
        }
        array2dPrint(arr4);

        //5
        arrayPrint(arrayInit(6, 3));

        //6
        int[] arr6 = {4, 7, 1, 3, 9, 6, -2};
        printMinMax(arr6);

        //7
        int[] arr7_1 = {2, 2, 2, 1, 2, 2, 10, 3};
        int[] arr7_2 = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.printf("The check balance is %b.\n", checkBalance(arr7_1));
        System.out.printf("The check balance is %b.\n", checkBalance(arr7_2));

        //8
        int[] arr8 = {1, 2, 3, 4, 5, 6, 7};
        arrayShift(arr8, -2);
        arrayPrint(arr8);
    }

    public static void arrayInversion(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
    }

    public static void arrayPrint(int[] arr) {

        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print(" ]\n");
    }

    public static void array2dPrint(int[][] arr) {

        for (int[] x : arr) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }

    public static int[] arrayInit(int length, int value) {

        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = value;
        }
        return result;
    }

    public static void printMinMax(int[] arr) {

        int min = arr[0];
        int max = arr[0];

        for(int el : arr) {
            if (min > el) min = el;
            if (max < el) max = el;
        }

        System.out.printf("Min: %d, Max: %d.\n", min, max);
    }

    public static boolean checkBalance(int[] arr) {

        boolean result = false;
        int sum = 0;

        for (int el : arr) sum += el;

        if (sum % 2 == 0) {

            int balance = sum / 2;
            int seek = 0;
            for (int el : arr) {
                seek += el;
                if (seek == balance) result = true;
                if (seek >= balance) break;
            }
        }
        return result;
    }

    public static void arrayShift(int[] arr, int n) {

        if (n > arr.length || -n > arr.length) {

            n = n % arr.length;
            if (n == 0)return;
        }

        boolean isLeft = false;
        if (n < 0) {
            n = -n;
            isLeft = true;
        }

        for (int i = 0; i < n; i++) {

            if (isLeft) {
                arrayShiftLeft(arr);
            } else {
                arrayShiftRight(arr);
            }
        }
    }

    public static void arrayShiftLeft(int[] arr) {

        int tmp = arr[0];

        for (int i = 1; i < arr.length; i++) {
            System.arraycopy(arr, i, arr, i -1, 1);
        }
        arr[arr.length - 1] = tmp;
    }

    public static void arrayShiftRight(int[] arr) {

        int tmp = arr[arr.length - 1];

        for (int i = arr.length - 1; i > 0; i--) {
            System.arraycopy(arr, i - 1, arr, i, 1);
        }
        arr[0] = tmp;
    }
}
