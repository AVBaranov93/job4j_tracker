package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemAscByNameTest {
    @Test
    public void whenAscSort() {
        List<Item> items = Arrays.asList(
                new Item(2, "two"),
                new Item(1, "one"),
                new Item(7, "seven"),
                new Item(5, "five")
        );
        List<Item> expected = Arrays.asList(
                new Item(5, "five"),
                new Item(1, "one"),
                new Item(7, "seven"),
                new Item(2, "two")
        );
        items.sort(new ItemAscByName());
        assertThat(expected).isEqualTo(items);
    }
}