package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LakeNazoma lake = new LakeNazoma();
        lake.placeLotus();
        lake.placeKillerFish();
        lake.placeRubberEater();
        SupperWarrior sw1 = lake.placeWarriors();
        SupperWarrior sw2 = lake.placeWarriors();

        // Create tasks for each warrior
        Runnable task1 = new WarriorSwimTask(sw1, lake);
        Runnable task2 = new WarriorSwimTask(sw2, lake);

        // Create an executor service with a fixed thread pool
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Submit tasks for execution
        executor.submit(task1);
        executor.submit(task2);

        // Shutdown the executor service
        executor.shutdown();


    }
}