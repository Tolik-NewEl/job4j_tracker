package ru.job4j.poly;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle train = new Train();
        Vehicle bus = new Buss();
        Vehicle aeroplan = new Plane();
        Vehicle parovoz = new Train();
        Vehicle ikarus = new Buss();

        Vehicle[] vehicles = new Vehicle[]{plane, train, bus, aeroplan, parovoz, ikarus};
        for (Vehicle a : vehicles) {
            a.move();
            a.type();
        }
    }
}
