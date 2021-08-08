package ru.job4j.poly;

import java.util.Scanner;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Пристегните ремни!");
    }

    @Override
    public void pass(int passengers) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Количество пассажиров: ");
        passengers = Integer.parseInt(scanner.nextLine());
    }

    @Override
    public double oil(double benz) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Количество топлива: ");
        benz = Integer.parseInt(scanner.nextLine());
        return benz * 45;
    }
}
