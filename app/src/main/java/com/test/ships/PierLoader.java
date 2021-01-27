package com.test.ships;

import android.util.Log;

import com.test.ships.ships.Ship;
import com.test.ships.ships.types.Type;

public class PierLoader implements Runnable {

    private Type shipType;
    private Tunnel tunnel;

    public PierLoader(Type shipType, Tunnel tunnel) {
        this.shipType = shipType;
        this.tunnel = tunnel;
    }

    @Override
    public void run() {

        while (true) {
            try {
                Thread.currentThread().setName("Loader" + shipType);
                Thread.sleep(500);

                Ship ship = tunnel.get(shipType);
                if (ship!=null){
                    while (ship.countCheck()){
                        Thread.sleep(100);
                        ship.add(10);
                        Log.d("Loader", "Ship count: " +ship.getCount() + " Loader ship: " + Thread.currentThread().getName());
                    }
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}