package ru.geekbrains.java1.lesson2;

import java.util.Arrays;

public class MainClass {
    public static void main(String[] args){
        /*
            1 Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
            Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;
        */

        int[] numArray = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(replaceOneZero(numArray)));

        /*
            2 Задать пустой целочисленный массив размером 8. Написать метод, который помощью цикла заполнит его
            значениями 1 4 7 10 13 16 19 22;
         */
        int[] arrayTask2 = new int[8];
        System.out.println(Arrays.toString(writeInArray(arrayTask2)));

        /*
            3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], написать метод, принимающий на вход массив и
            умножающий числа меньше 6 на 2;
         */
        int[] arrayTask3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(checkValue(arrayTask3)));

        /*
            4 Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента;
         */
        float[] arrayTask4 = {25.72f, 41.23f, 2.36f, 14.56f, 4.23f};
        //или
        System.out.println("Минимальное значение в массиве: " + arrayTask4[searchMinMax(arrayTask4)[0]]
                + ". Максимальное значение в массиве: " + arrayTask4[searchMinMax(arrayTask4)[1]]);
        //по заданию
        System.out.println("Минимальное значение в массиве: " + arrayTask4[searchMin(arrayTask4)]);
        System.out.println("Максимальное значение в массиве: " + arrayTask4[searchMax(arrayTask4)]);
        /*
            5 * Создать квадратный целочисленный массив (количество строк и столбцов одинаковое), заполнить его
            диагональные элементы единицами, используя цикл(ы);
         */
        int[][] arrayTask5 = new int[5][5];
        printArray(diagWriteIn(arrayTask5));
        /*
            6 ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть
            true если в массиве есть место, в котором сумма левой и правой части массива равны.
            Примеры: checkBalance([1, 1, 1, 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false,
            checkBalance ([10, 1, 2, 3, 4]) → true.
         */
        int[] arrayTask6 = {6, 8, 8, 2, 20};
        System.out.println(checkBalance(arrayTask6));

        /*
            7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, и
            ли отрицательным), при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи
            нельзя пользоваться вспомогательными массивами.
         */
        int diff = 1;
        String[] arrayTask7 = {"Hello", "Bye", "Good day", "Good evening", "Good morning"};
        System.out.println(Arrays.toString(offsetElement(arrayTask7, diff)));
    }

    /*
            1 Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
            Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;
     */
    private static int[] replaceOneZero(int[] array){
        for(int i = 0; i < array.length; i++){
            array[i] = array[i] == 0 ? 1 : 0;
        }
        return array;
    }

    /*
            2 Задать пустой целочисленный массив размером 8. Написать метод, который помощью цикла заполнит его
            значениями 1 4 7 10 13 16 19 22;
     */
    private static int[] writeInArray(int[] array){
        for (int i = 0; i < array.length; i++){
            array[i] = 3 * i + 1;
        }
        return array;
    }

    /*
            3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], написать метод, принимающий на вход массив и
            умножающий числа меньше 6 на 2;
     */
    private static int[] checkValue(int[] array){
        for(int i = 0; i < array.length; i++){
            if(array[i] < 6 ){
                array[i]*=2;
            }
        }
        return array;
    }

    /*
            4 Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента;
     */
    private static int[] searchMinMax(float[] array){
        int[] minMax = new int[2];
        float min = array[0];
        float max = array[0];
        for (int i = 0; i < array.length; i++){
            if (array[i] < min) {
                minMax[0] = i;
                min = array[i];
            }
            if (array[i] > max) {
                minMax[1] = i;
                max = array[i];
            }
        }
        return minMax;
    }
    //по заданию
    private static int searchMin(float[] array){
        int index = 0;
        float min = array[0];
        for (int i = 0; i < array.length; i++){
            if (array[i] < min){
                index = i;
                min = array[i];
            }
        }
        return index;
    }
    private static int searchMax(float[] array){
        int index = 0;
        float max = array[0];
        for (int i = 0; i < array.length; i++){
            if (array[i] > max){
                index = i;
                max = array[i];
            }
        }
        return index;
    }

    /*
            5 * Создать квадратный целочисленный массив (количество строк и столбцов одинаковое), заполнить его
            диагональные элементы единицами, используя цикл(ы);
     */
    private static int[][] diagWriteIn(int[][] arrays){
        for(int i = 0; i < arrays.length; i++){
            for(int j = 0; j < arrays[i].length; j++){
                if(i == j || j == arrays[i].length - i - 1){
                    arrays[i][j] = 1;
                }
            }
        }
        return arrays;
    }
    //Метод печати двумерного массива
    private static void printArray(int[][] array){
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    /*
            6 ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть
            true если в массиве есть место, в котором сумма левой и правой части массива равны.
            Примеры: checkBalance([1, 1, 1, 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false,
            checkBalance ([10, 1, 2, 3, 4]) → true.
     */
    private static boolean checkBalance(int[] array){
        boolean result = false;
        int sum = 0;
        for (int i = 0; i < array.length; i++){
            sum+=array[i];
        }
        for (int i = 0, sumLeft = 0; i < array.length - 1; i++){
            sumLeft+=array[i];
            if(i > 0 && i != array.length - 2 && sumLeft == sum - sumLeft){
                result = true;
                break;
            }
        }
        return result;
    }

    /*
            7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, и
            ли отрицательным), при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи
            нельзя пользоваться вспомогательными массивами.
     */
    private static String[] offsetElement(String[] array, int n){
        if(n != 0) {
            if (Math.abs(n) > array.length) {
                n = n > 0 ? n - array.length : n + array.length;
            }
            for (int i = 0; i < Math.abs(n); i++) {
                String temp = null;
                if (n > 0) {
                    for (int j = array.length - 1; j > 0; j--) {
                        if (j == array.length - 1) {
                            temp = array[j];
                        }
                        array[j] = array[j - 1];
                    }
                    array[0] = temp;
                } else if (n < 0) {
                    for (int j = 0; j < array.length - 1; j++) {
                        if (j == 0) {
                            temp = array[j];
                        }
                        array[j] = array[j + 1];
                    }
                    array[array.length - 1] = temp;
                }
            }
        }
        return array;
    }
}

