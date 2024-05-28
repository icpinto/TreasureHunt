package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LakeNazoma lake = new LakeNazoma();
        lake.placeLotus();
        lake.placeKillerFish();
        lake.placeRubberEater();
        SupperWarrior sw1 = lake.placeWarriors();

        sw1.swim(lake);

    }
}