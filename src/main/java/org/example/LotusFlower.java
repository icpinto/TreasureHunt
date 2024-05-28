package org.example;

public class LotusFlower {
    private int petalCount = 100;
    private int petalId;
    private int[] location;


    public LotusFlower(int petalId, int[] location) {
        this.petalId = petalId;
        this.location = location;
    }

    public void pickLotusPetal(){
        if(this.petalCount > 0 ) {
            this.petalCount--;
        }
    }

    public int getPetalCount(){
        return this.petalCount;
    }

    public int[] getLocation() {
        return location;
    }

    public int getPetalId() {
        return petalId;
    }
}
