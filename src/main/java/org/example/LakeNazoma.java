package org.example;

import java.util.List;

public class LakeNazoma {
    public static int[][] grid;
    public static int[][] warriorsLocation = new int[1][2];
    public static int[][] lotusLocation= new int[1][2];
    public static int[][] killerFishLocation= new int[1][2];
    public static int[][] ruberEaterLocation= new int[1][2];

    public void placeLotus(){
        int x,y;
        do {
            x = (int) (Math.random() * 11);
            y = (int) (Math.random() * 11);
        } while (isOccupied(x, y, lotusLocation));
        LotusFlower l1 = new LotusFlower(1, new int[]{x, y});
        System.out.println("Lotus setup at " + x + "," + y);
        lotusLocation[0] = new int[]{x, y};
    }

    public void placeKillerFish(){
        int x,y;
        do {
            x = (int) (Math.random() * 11);
            y = (int) (Math.random() * 11);
        } while (isOccupied(x, y, killerFishLocation));
        KillerFish kf1 = new KillerFish(1, new int[]{x, y});
        System.out.println("Killer fish setup at " + x + "," + y);
        killerFishLocation[0] = new int[]{x,y};
    }

    public void placeRubberEater(){
        int x,y;
        do {
            x = (int) (Math.random() * 11);
            y = (int) (Math.random() * 11);
        } while (isOccupied(x, y, ruberEaterLocation));
        RubberEater rb1 = new RubberEater(1, new int[]{x,y});
        System.out.println("Rubber eater setup at " + x + "," + y);
        ruberEaterLocation[0] = new int[]{x, y};
    }

    public SupperWarrior placeWarriors(){
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

    private Boolean isOccupied(int x, int y, int[][] otherOccupents) {
        if (otherOccupents.length > 0) {
            for (int i = 0; i < otherOccupents.length; i++) {
                if (otherOccupents[i][0] == x && otherOccupents[i][1] == y) {
                    return true;
                }
            }
        }
        return false;
    }



    public int[][] getGrid() {
        return grid;
    }

    public int[][] getWarriorsLocation() {
        return warriorsLocation;
    }

    public int[][] getLotusLocation() {
        return lotusLocation;
    }

    public int[][] getKillerFishLocation() {
        return killerFishLocation;
    }

    public int[][] getRuberEaterLocation() {
        return ruberEaterLocation;
    }

}
