package ru.job4j.stream;


import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


class MatrixToListTest {
    @Test
    public void whenInputSquareMatrix() {
        Integer[][] input = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> result = MatrixToList.convert(input);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void whenInputNonSquareMatrix() {
        Integer[][] input = {
                {1},
                {2, 3},
                {4, 5, 6}
        };
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> result = MatrixToList.convert(input);
        assertThat(result).containsAll(expected);
    }

}