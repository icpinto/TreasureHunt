package org.example;

import java.util.ArrayList;

public class SupperWarrior extends  Warrior{
    public static final boolean hasBin = true;

    public SupperWarrior(int id, int[] location) {
        super(id, location);
    }

    @Override
    public void swim(LakeNazoma lakeNazoma) {
        while(this.getHasFins() && this.getAlive() && !this.getWinner()){
            int[] nextValidLocation = new int[0];
            boolean found = false;
            ArrayList<ArrayList<Integer>> nextValidLocations = this.getNextValidLocations(LakeNazoma.warriorsLocation);
            for(int i=0; i < nextValidLocations.size(); i++){
                int nextXLocation = nextValidLocations.get(i).get(0);
                int nextYLocation = nextValidLocations.get(i).get(1);

                if(this.checkForLotus(LakeNazoma.lotusLocation, new int[]{nextXLocation, nextYLocation})){
                    nextValidLocation = new int[]{nextXLocation, nextYLocation};
                    this.setImmortality(true);
                    found = true;
                }
            }
            if(!found){
                // generating the index using Math.random()
                int index = (int)(Math.random() * nextValidLocations.size());
                nextValidLocation = new int[]{nextValidLocations.get(index).get(0), nextValidLocations.get(index).get(1)};
            }
            // update the status
            this.updateWarriorStatus(LakeNazoma.killerFishLocation, LakeNazoma.ruberEaterLocation, nextValidLocation);

            //update warrior location
            this.updateWarriorLocation(nextValidLocation, LakeNazoma.warriorsLocation);
        }
    }


    private boolean checkForLotus(int[][] lotusLocations, int[] warriorNextLocation) {
        for(int i=0; i < lotusLocations.length; i++){
            if (lotusLocations[i][0]== warriorNextLocation[0] && lotusLocations[i][1]== warriorNextLocation[1]){
                return true;
            }
        }
        return false;
    }

    private void updateWarriorStatus(int[][] killerFishLocations, int[][] rubberEatersLocations, int[] warriorNewLocation) {
        if(warriorNewLocation[0]==5 && warriorNewLocation[1]==5){
            this.setWinner(true);
            System.out.println("--------Won the Game-----------");
        }
        for (int i = 0; i < killerFishLocations.length; i++) {
            if (killerFishLocations[i][0] == warriorNewLocation[0] && killerFishLocations[i][1] == warriorNewLocation[1] && !this.getImmortality()) {
                this.setAlive(false);
                System.out.println("--------Ate by Killer Fisher-------------");
            }
        }

        for (int i = 0; i < rubberEatersLocations.length; i++) {
            if (rubberEatersLocations[i][0] == warriorNewLocation[0] && rubberEatersLocations[i][1] == warriorNewLocation[1] && !this.getImmortality()) {
                this.setHasFins(false);
                System.out.println("-----------Ate by RubberEater-----------");
            }
        }
    }

    private void updateWarriorLocation(int[] warriorNewLocation, int[][] warriorsLocations){
        int[] oldLocation = this.getLocation();
        for(int i=0; i< warriorsLocations.length; i++){
            if(warriorsLocations[i][0]== oldLocation[0] && warriorsLocations[i][1]== oldLocation[1]){
                this.setLocation(warriorNewLocation);
                LakeNazoma.warriorsLocation[i][0]=warriorNewLocation[0];
                LakeNazoma.warriorsLocation[i][1]=warriorNewLocation[1];
            }
        }

        System.out.println("Warrior " + this.getId() + " moved from " +oldLocation[0]+","+ oldLocation[1] + " to " + warriorNewLocation[0] + "," + warriorNewLocation[1]);

    }

}
