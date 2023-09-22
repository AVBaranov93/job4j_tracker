package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemDescByNameTest {
    @Test
    public void whenDescSortByName() {
        List<Item> items = Arrays.asList(
                new Item(2, "two"),
                new Item(1, "one"),
                new Item(7, "seven"),
                new Item(5, "five")
        );
        List<Item> expected = Arrays.asList(
                new Item(2, "two"),
                new Item(7, "seven"),
                new Item(1, "one"),
                new Item(5, "five")
        );
        items.sort(new ItemDescByName());
        assertThat(expected).isEqualTo(items);
    }
}