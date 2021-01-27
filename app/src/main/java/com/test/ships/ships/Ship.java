package com.test.ships.ships;

import com.test.ships.ships.types.Size;
import com.test.ships.ships.types.Type;

public class Ship {
    private int count;
    private Size size;
    private Type type;

    public Ship(Size size, Type type){
        this.size = size;
        this.type = type;
    }

    public void add(int count){
        this.count += count;
    }

    public boolean countCheck(){
        return count < size.getValue();
    }
    public Size getSize(){
        return size;
    }
    public Type getType(){
        return type;
    }
    public int getCount(){
        return count;
    }
}
