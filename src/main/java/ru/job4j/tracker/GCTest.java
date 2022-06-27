package ru.job4j.tracker;

public class GCTest {

    public static void main(String[] args) {
        MemTracker memTracker = new MemTracker();
        long startTime = System.currentTimeMillis();
        for (int i = 1; i < 100000; i++) {
            memTracker.add(new Item("Item " + i));
        }
        System.out.printf("Working time %d", System.currentTimeMillis() - startTime);
    }
}
