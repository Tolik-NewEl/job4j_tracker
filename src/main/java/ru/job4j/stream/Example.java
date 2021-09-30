package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Example {
    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>();
        values.add(1);
        values.add(-2);
        values.add(3);
        values.add(-4);
        values.add(5);
        List<Integer> positive = values.stream().filter(
                value -> value > 0
        ).collect(Collectors.toList());
        positive.forEach(System.out::println);
    }
}
