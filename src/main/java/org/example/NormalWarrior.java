package org.example;

public class NormalWarrior extends Warrior{
    public NormalWarrior(int id, int[] location) {
        super(id, location);
    }

    @Override
    public void swim(LakeNazoma lakeNazoma) {

    }


    public boolean checkForLotus() {
        return false;
    }
}
