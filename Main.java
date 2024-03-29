package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static final int LENGTH = 5;
    public static final int WIDTH = 3;
    public static final Random R = new Random ();


    public static void main(String[] args) {


        int[] array = {35, 19, 85, 96};
        int[] array2 = {11, 95, 98, 25};

        System.out.println(daysCounter(MonthsOfYear.APRIL));
        System.out.println(differenceMinMax(array));
        System.out.println(compareArrays(array, array2));
        System.out.println (findMissing());

        System.out.println (minElementTwoDimArray (foundTwoDimArray (LENGTH, WIDTH )));
        printTwoDimArray (invertElementsTwoDimArray(foundTwoDimArray (LENGTH, WIDTH )));
        printTwoDimArray(invertOddElementsTwoDimArray (foundTwoDimArray (LENGTH, WIDTH )));

   }

    public static int daysCounter(MonthsOfYear month) {
        int days = 0;
        switch (month) {
            case JANUARY:
                days = 31;
                break;
            case FEBRUARY:
                days = 28;
                break;
            case MARCH:
                days = 30;
                break;
            case APRIL:
                days = 30;
                break;
            case MAY:
                days = 31;
                break;
            case JUNE:
                days = 30;
                break;
            case JULY:
                days = 31;
                break;
            case AUGUST:
                days = 31;
                break;
            case SEPTEMBER:
                days = 30;
                break;
            case OCTOBER:
                days = 31;
                break;
            case NOVEMBER:
                days = 30;
                break;
            case DECEMBER:
                days = 31;
                break;
            default:
        }
        return days;
    }

    public static int differenceMinMax(int[] array) {
        int difference;
        int max = array[0];
        int min = array[0];
        for (int i : array) {
            if (max < i)
                max = i;
            if (min > i)
                min = i;
        }
        difference = max - min;
        return difference;
    }

    public static boolean compareArrays(int[] array, int[] array2) {
        for (int i = 0; i < array2.length; i++) {
            if (array2[i] != (array[i])) {
                return false;
            }
        }
        return true;
    }

    public static int findMissing() {
        int[] array1 = {9, 8, 7, 6, 5, 4, 2, 0, 1};
        int sum = 0;
        for (int i = 1; i <= 9; i++) {
            sum += i - array1[i - 1];
        }
        return sum;
    }

    public static int[][] foundTwoDimArray (int LENGTH, int WIDTH ){
        int[][] twoDimArray = new int[LENGTH][WIDTH];
               for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray[i].length; j++) {
                twoDimArray[i][j] = R.nextInt(9);
            }
        }
        return twoDimArray;
            }
    public static void printTwoDimArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }


    public static int minElementTwoDimArray(int[][] array) {
        int minElement = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < minElement) {
                    minElement = array[i][j];
                }
            }
        }
        return minElement;
    }
    public static int [] [] invertElementsTwoDimArray(int[][] array) {
        int maxI = 0;
        int maxJ = 0;
        int minI = 0;
        int minJ = 0;
        int maxElement = array[0][0];
        int minElement =minElementTwoDimArray(array);
            for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == minElement) {
                    minI = i;
                    minJ = j;
                }
                if (array[i][j] > maxElement) {
                    maxElement = array[i][j];
                    maxI = i;
                    maxJ = j;
                }
            }
        }
        array[maxI][maxJ] = minElementTwoDimArray(array);
        array[minI][minJ] = maxElement;
        return array;
    }


    public static int[][] invertOddElementsTwoDimArray (int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if ((array[i][0]) % 2 != 0 ) {
                    array[i][j] = 0;
                }
                if (array[i][j] % 2 != 0 && j != 0) {
                    array[i][j] = array[i][j - 1];
                }
            }
        }
        return array;
    }
}




