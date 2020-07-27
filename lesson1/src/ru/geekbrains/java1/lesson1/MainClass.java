package ru.geekbrains.java1.lesson1;

public class MainClass {
    public static void main(String[] args){

        //Task 1
        System.out.println(calculateMethod(10,5,2,5));
        //Task 2
        System.out.println(checkSum(10,20));
        //Task 3
        if(checkPositive(10)){
            System.out.println("Число положительное!");
        } else{
            System.out.println("Число отрицательное");
        }
        //Task 4
        sayHello("Roman");
        //Task 5
        System.out.println(checkLeapYear(2029));

    }

    /*
    Задание 1.
    Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат с плавающей точкой,
     где a, b, c, d – целочисленные входные параметры этого метода;
    */
    private static float calculateMethod(int a, int b, int c, int d){
        float result = 0;
        if(d != 0){
            result = a * (b + (c / d));
        } else {
            System.out.println("На ноль делить нельзя!");
        }
        return result;
    }
    /*
    Задание 2.
    Написать метод, принимающий на вход два целых числа, и проверяющий что их сумма лежит в пределах от 10 до 20
    (включительно), если да – вернуть true, в противном случае – false;
     */
    private static boolean checkSum(int a, int b){
        if (a + b >= 10 && a + b <= 20){
            return true;
        } else {
            return false;
        }
    }
    /*
    Задание 3.
    Написать метод, которому в качестве параметра передается целое число, метод должен проверить положительное ли число
    передали, или отрицательное. Замечание: ноль считаем положительным числом. Результат работы метода вывести в консоль
     */
    private static boolean checkPositive(int a){
        if(a>=0){
            return true;
        } else {
            return false;
        }
    }
    /*
    Задание 4.
    Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вернуть
    приветственное сообщение «Привет, переданное_имя!»; Вывести приветствие в консоль.
     */
    private static void sayHello(String a){
        System.out.println(a + ", hello!");
    }
    /*
    Задание 5.
    Написать метод, который определяет является ли год високосным. Каждый 4-й год является високосным, кроме каждого
    100-го, при этом каждый 400-й – високосный. Для проверки работы вывести результаты работы метода в консоль
     */
    private static boolean checkLeapYear(int a){
        if( a >= 0 && a % 4 == 0 && a % 100 != 0 || a >= 0 && a % 400 == 0){ //Если считать отрицательный год как год До н.э. убрать условие a >= 0;
            return true;
        } else {
            return false;
        }
    }
}

