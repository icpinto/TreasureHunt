package org.example;

import java.util.List;

public class LakeNazoma {
    private static int[][] grid;
    private static int[][] warriorsLocation = new int[2][2];
    private static int[][] lotusLocation= new int[2][2];
    private static int[][] killerFishLocation= new int[2][2];
    private static int[][] ruberEaterLocation= new int[2][2];

    public synchronized void placeLotus(){
        int x,y;
        do {
            x = (int) (Math.random() * 11);
            y = (int) (Math.random() * 11);
        } while (isOccupied(x, y, lotusLocation));
        LotusFlower l1 = new LotusFlower(1, new int[]{x, y});
        System.out.println("Lotus setup at " + x + "," + y);
        lotusLocation[0] = new int[]{x, y};
    }

    public synchronized void placeKillerFish(){
        int x,y;
        do {
            x = (int) (Math.random() * 11);
            y = (int) (Math.random() * 11);
        } while (isOccupied(x, y, killerFishLocation));
        KillerFish kf1 = new KillerFish(1, new int[]{x, y});
        System.out.println("Killer fish setup at " + x + "," + y);
        killerFishLocation[0] = new int[]{x,y};
    }

    public synchronized void placeRubberEater(){
        int x,y;
        do {
            x = (int) (Math.random() * 11);
            y = (int) (Math.random() * 11);
        } while (isOccupied(x, y, ruberEaterLocation));
        RubberEater rb1 = new RubberEater(1, new int[]{x,y});
        System.out.println("Rubber eater setup at " + x + "," + y);
        ruberEaterLocation[0] = new int[]{x, y};
    }

    public synchronized SupperWarrior placeWarriors(){
        int x,y;
        do {
            x = (int) (Math.random() * 11);
            y = (int) (Math.random() * 11);
        } while (isOccupied(x, y, warriorsLocation));
        SupperWarrior sw1 = new SupperWarrior(x, new int[]{x,y});
        System.out.println("Warrior setup at " + x + "," + y);
        warriorsLocation[0] = new int[]{x,y};
        return sw1;
    }

    private synchronized Boolean isOccupied(int x, int y, int[][] otherOccupents) {
        if (otherOccupents.length > 0) {
            for (int i = 0; i < otherOccupents.length; i++) {
                if (otherOccupents[i][0] == x && otherOccupents[i][1] == y) {
                    return true;
                }
            }
        }
        return false;
    }



    public synchronized int[][] getGrid() {
        return grid;
    }

    public static synchronized int[][] getWarriorsLocation() {
        return warriorsLocation;
    }

    public static synchronized int[][] getLotusLocation() {
        return lotusLocation;
    }

    public static synchronized int[][] getKillerFishLocation() {
        return killerFishLocation;
    }

    public static synchronized int[][] getRuberEaterLocation() {
        return ruberEaterLocation;
    }

}
