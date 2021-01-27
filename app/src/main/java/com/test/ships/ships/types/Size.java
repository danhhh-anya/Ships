package com.test.ships.ships.types;

public enum Size {
    LOW(10),
    MEDIUM(50),
    HARD(100);

    private final int value;
    Size(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
