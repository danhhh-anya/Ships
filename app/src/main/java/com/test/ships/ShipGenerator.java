package com.test.ships;

import com.test.ships.ships.Ship;
import com.test.ships.ships.types.Size;
import com.test.ships.ships.types.Type;

import java.util.Random;

public class ShipGenerator implements Runnable {
    private Tunnel tunnel;
    private int shipCounter;

    public ShipGenerator(Tunnel tunnel, int shipCounter) {
        this.tunnel = tunnel;
        this.shipCounter = shipCounter;
    }

    @Override
    public void run() {
    int count = 0;
    while (count < shipCounter){
        Thread.currentThread().setName("Generate ship");
        count++;
        tunnel.add(new Ship(getRandomSize(), getRandomType()));
        try {
            Thread.sleep(1000);
        } catch ( InterruptedException e){
            e.printStackTrace();
        }
    }
    }

    private Type getRandomType() {
        return Type.values()[new Random().nextInt(Type.values().length)];
    }

    private Size getRandomSize() {
        return Size.values()[new Random().nextInt(Size.values().length)];
    }
}