package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class MaxTest {

    @Test
    public void whenMax3Then3() {
        int first = 1;
        int second = 2;
        int third = 3;
        int result = Max.max(first, second, third);
        int expected = 3;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenMax4Then4() {
        int first = 2;
        int second = 1;
        int third = 3;
        int fourth = 5;
        int result = Max.max(first, second, third, fourth);
        int expected = 5;
        Assert.assertEquals(result, expected);
    }
}