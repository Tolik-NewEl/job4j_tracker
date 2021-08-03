package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Я великий Оракул. Что ты хочешь узнать? ");
        String name = input.nextLine();
        int answer = new Random().nextInt(3);
        String value = switch (answer) {
            case 0 -> "да";
            case 1 -> "нет";
            default -> "может быть";
        };
        System.out.println(value);
    }
}
