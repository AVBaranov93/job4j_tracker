package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int itemId = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(itemId++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findByName(String name) {
        Item[] result = new Item[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (name.equals(items[i].getName())) {
                result[count++] = items[i];
            }
        }
        return Arrays.copyOf(result, count);
    }

    public Item[] findAll() {
        return Arrays.copyOf(this.items, size);
    }
}