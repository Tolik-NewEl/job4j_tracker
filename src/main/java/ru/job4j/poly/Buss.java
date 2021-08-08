package ru.job4j.poly;

public class Buss implements Vehicle {

    @Override
    public void move() {
        System.out.print(getClass().getSimpleName() + " двигается по скоростным трассам,");
    }

    @Override
    public void type() {
        System.out.println(" ведь это автобус.");
    }
}
