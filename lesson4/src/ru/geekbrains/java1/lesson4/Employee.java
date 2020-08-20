package ru.geekbrains.java1.lesson4;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Employee {
    private static final LocalDate CURRENT_DATE = LocalDate.now();
    private int age;
    private String name;
    private String lastName;
    private String patronymic;
    private double salary;
    private int employeeID;
    private static int currentID = 1;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    Employee(){
    }

    Employee(String lastName, String name, String patronymic, String birthDay, double salary){
        this.name = name;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.salary = salary;
        age = setAge(LocalDate.parse(birthDay, formatter));
        employeeID = currentID++;
    }
    //calculate age
    private int setAge(LocalDate birthDay){
        if(birthDay != null) {
            return Period.between(birthDay, CURRENT_DATE).getYears();
        }
        return 0;
    }
    //setter
    public void setSalary(double salary){
        this.salary = salary;
    }
    //getter
    public int getAge(){
        return this.age;
    }
    public String getName(){
        return this.name;
    }
    public String getFullName(){
        return lastName + " " + name + " " + patronymic;
    }
    public double getSalary(){
        return this.salary;
    }
    public int getEmployeeID(){
        return employeeID;
    }
    public static int getCountID(){
        return currentID ;
    }
}
