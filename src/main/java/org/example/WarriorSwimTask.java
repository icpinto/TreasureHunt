package org.example;

public class WarriorSwimTask implements Runnable {
    private Warrior warrior;
    private LakeNazoma lake;

    public WarriorSwimTask(Warrior warrior, LakeNazoma lake) {
        this.warrior = warrior;
        this.lake = lake;
    }

    @Override
    public void run() {
        warrior.swim(lake);
    }
}
