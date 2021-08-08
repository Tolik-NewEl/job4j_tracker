package ru.job4j.poly;

public class Plane implements Vehicle {

    @Override
    public void move() {
        System.out.print(getClass().getSimpleName() + " летит по воздуху,");
    }

    @Override
    public void type() {
        System.out.println(" ведь это самолет.");
    }
}