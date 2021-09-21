package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftOne = left.split("\\.");
        String[] rightOne = right.split("\\.");
        int lt = Integer.parseInt(leftOne[0]);
        int rt = Integer.parseInt(rightOne[0]);
        return Integer.compare(lt, rt);
    }
}
