package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftOne = left.split("\\.");
        String[] rightOne = right.split("\\.");
        return Integer.compare(Integer.parseInt(leftOne[0]),
                Integer.parseInt(rightOne[0]));
    }
}
