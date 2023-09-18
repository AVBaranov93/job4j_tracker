package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int itemId = 1;

    public Item add(Item item) {
        item.setId(itemId++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (Item item : items) {
            if (id == item.getId()) {
                rsl = item;
            }
        }
        return rsl;
    }

    public List<Item> findByName(String name) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (name.equals(item.getName())) {
                result.add(item);
            }
        }
        return result;
    }

    public List<Item> findAll() {
        return items;
    }

    public boolean replace(int id, Item item) {
        boolean result = false;
        for (Item rsl : items) {
            if (id == rsl.getId()) {
                item.setId(id);
                items.set(items.indexOf(rsl), item);
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean delete(int id) {
        boolean result = false;
        for (Item rsl : items) {
            if (id == rsl.getId()) {
                items.remove(rsl);
                result = true;
                break;
            }
        }
        return result;
    }
}