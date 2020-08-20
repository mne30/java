package ru.geekbrains.java1.lesson5;

import ru.geekbrains.java1.lesson5.zoo.Cat;
import ru.geekbrains.java1.lesson5.zoo.Dog;

public class MainClass {
    private static Animal[] animals;
    public static void main(String[] args){

        animals = new Animal[]{
                new Cat("Barsik", "30.12.1999", "black", 100.00f, 4.25f),
                new Dog("Chernysh", "30.12.1999", "white", 600.00f, 5.00f, 20.00f),
                new Dog("Belyshik", "30.12.1999", "orange", 100.00f, 1.00f, 40.00f)
        };
        gameOlymp(550f,3f,30f);

    }
    private static void swim(Animal anim, float swimLen){
        if(anim.swim(swimLen)){
            System.out.println(anim.name + " смог проплыть " + swimLen + "м !");
        } else {
            System.out.println(anim.name + " не смог проплыть!");
        }
    }
    private static void run(Animal anim, float moveLen){
        if(anim.move(moveLen)){
            System.out.println(anim.name + " смог пробежать " + moveLen + "м !");
        } else {
            System.out.println(anim.name + " не смог пробежать!");
        }
    }
    private static void jump(Animal anim, float jumpHei){
        if(anim.move(jumpHei)){
            System.out.println(anim.name + " смог прыгнуть на " + jumpHei + "м !");
        } else {
            System.out.println(anim.name + " не смог прыгнуть!");
        }
    }

    private static void gameOlymp(float swim, float run, float jump){
        for (int i = 0; i < animals.length; i++){
            if(animals[i] instanceof Cat) {
                System.out.println(animals[i].name + " не умеет плавать, он же котик!");
                run(animals[i], run);
                jump(animals[i], jump);
                continue;
            }
            run(animals[i], run);
            jump(animals[i], jump);
            swim(animals[i], swim);
        }
    }

}
