package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    @Test
    public void when00to20then2() {
        double expected = 2;
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double dist = a.distance(b);
        Assert.assertEquals(expected, dist, 0.01);
    }

    @Test
    public void when10to20then1() {
        double expected = 1;
        Point a = new Point(1, 0);
        Point b = new Point(2, 0);
        double dist = a.distance(b);
        Assert.assertEquals(expected, dist, 0.01);
    }

    @Test
    public void when100to200then1() {
        double expected = 1;
        Point a = new Point(1, 0, 0);
        Point b = new Point(2, 0, 0);
        double dist = a.distance3d(b);
        Assert.assertEquals(expected, dist, 0.01);
    }

    @Test
    public void when101to301then2() {
        double expected = 2;
        Point a = new Point(1, 0, 1);
        Point b = new Point(3, 0, 1);
        double dist = a.distance3d(b);
        Assert.assertEquals(expected, dist, 0.01);
    }
}