package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Warrior {
    private int id;
    private int[] location = new int[2];
    private Boolean immortality = false;
    private Boolean hasFins = true;
    private Boolean alive = true;
    private Boolean isWinner = false;
    private static int count =0;
    private int[][] nextMove = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    public Warrior(int id, int[] location) {
        this.id = id;
        this.location = location;
    }

    public abstract void swim(LakeNazoma lakeGrid);
    //public abstract boolean checkForLotus();

    public boolean canSwim(){
        return this.hasFins;
    }

    public int[] getLocation() {
        return location;
    }

    public void setLocation(int[] location) {
        this.location = location;
    }

    public  int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getImmortality() {
        return immortality;
    }

    public void setImmortality(Boolean immortality) {
        this.immortality = immortality;
    }

    public Boolean getHasFins() {
        return hasFins;
    }

    public void setHasFins(Boolean hasFins) {
        this.hasFins = hasFins;
    }

    public Boolean getAlive() {
        return alive;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }

    public Boolean getWinner() {
        return isWinner;
    }

    public void setWinner(Boolean winner) {
        isWinner = winner;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Warrior.count++;
    }

    protected ArrayList<ArrayList<Integer>> getNextValidLocations(int[][] warriorsLocations){
        ArrayList<ArrayList<Integer>> nextValidLocations = new ArrayList<>();
        for (int i=0; i <4; i++){
            int new_x = this.location[0] + nextMove[i][0];
            int new_y = this.location[1] + nextMove[i][1];
            //System.out.println(this.location[0] + ","+ this.location[1] + ","+ nextMove[i][0]+ ","+ nextMove[i][1] );

            if((-1 < new_x) && (new_x < 11) &&
                    (-1 < new_y) && (new_y < 11)){
                boolean found = false;
                for( int j=0; j < warriorsLocations.length; j++){
                    if(warriorsLocations[j][0]==new_x && warriorsLocations[j][1]==new_y){
                        found = true;
                    }
                }
                if(!found){
                    nextValidLocations.add(new ArrayList<>(Arrays.asList(new_x, new_y)));
                }

            }
        }
        return nextValidLocations;
    }
}
