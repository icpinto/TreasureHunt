package org.example;

public class RubberEater extends Fish{
    public RubberEater(int fishId, int[] location) {
        super(fishId, location);
    }

    public void eatFins(Warrior w){
        w.setHasFins(false);
    }
}
