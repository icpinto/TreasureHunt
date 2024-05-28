package org.example;

public abstract class Fish {
    private int fishId;
    private int[] location;

    public Fish(int fishId, int[] location) {
        this.fishId = fishId;
        this.location = location;
    }

    public int getFishId() {
        return fishId;
    }

    public int[] getLocation() {
        return location;
    }
}
