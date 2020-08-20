package ru.geekbrains.java1.lesson5.zoo;

import ru.geekbrains.java1.lesson5.Animal;

public class Dog extends Animal {

    public Dog (String name, String birthDay, String color, float moveLength, float heighJump, float swimLength){
        super(name, birthDay, color);
        super.moveLength = moveLength;
        super.heighJump = heighJump;
        super.swimLength = swimLength; ;
    }

    @Override
    public boolean voice(){
        return false; //Заглушка
    }
    @Override
    public boolean move(float moveLen){
        if(moveLen > 0 && this.moveLength >= moveLen){
            return true;
        }
        return false;
    }
    @Override
    public boolean jump(float hJump){
        if(hJump > 0 && this.heighJump >= hJump){
            return true;
        }
        return false;
    }
    @Override
    protected boolean swim(float swimLen){
        if(swimLen > 0 && this.swimLength >= swimLen){
            return true;
        }
        return false;
    }

}
