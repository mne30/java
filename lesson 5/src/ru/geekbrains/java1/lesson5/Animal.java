package ru.geekbrains.java1.lesson5;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public abstract class Animal {

    protected String birthDay;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private static final LocalDate CURRENT_DATE = LocalDate.now();
    protected int age;
    protected String color;
    protected String name;
    protected float heighJump;
    protected float moveLength;
    protected float swimLength;

    protected Animal(String birthDay, String color){
        age = setAge(LocalDate.parse(birthDay, formatter));
        this.color = color;
    }
    protected Animal(String name, String birthDay, String color){
        this.name = name;
        age = setAge(LocalDate.parse(birthDay, formatter));
        this.color = color;
    }
    protected Animal(String name, String birthDay, String color, float moveLength, float heighJump, float swimLength){
        this.name = name;
        age = setAge(LocalDate.parse(birthDay, formatter));
        this.color = color;
        this.moveLength = moveLength;
        this.heighJump = heighJump;
        this.swimLength = swimLength;
    }

    protected abstract boolean voice();
    protected abstract boolean move(float moveLength);
    protected abstract boolean jump(float heighJump);
    protected abstract boolean swim(float swimLength);

    //calculate age
    private int setAge(LocalDate birthDay){
        if(birthDay != null) {
            return Period.between(birthDay, CURRENT_DATE).getYears();
        }
        return 0;
    }
}
