package org.example;

public class KillerFish extends Fish{

    public KillerFish(int fishId, int[] location) {
        super(fishId, location);
    }

    public void killWorrier(Warrior w){
        w.setAlive(false);
    }
}
