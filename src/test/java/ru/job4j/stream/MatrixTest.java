package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MatrixTest {
    @Test
    public void convertMatrixToList() {
        Integer[][] matrix = new Integer[2][2];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[1][0] = 3;
        matrix[1][1] = 4;
        Matrix tmp = new Matrix();
        List<Integer> rsl = tmp.convert(matrix);
        List<Integer> expected = Arrays.asList(
                1, 2, 3, 4
        );
        assertThat(rsl, is(expected));
    }

}