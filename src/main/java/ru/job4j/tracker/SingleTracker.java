package ru.job4j.tracker;

import java.util.List;

public final class SingleTracker {
    private static SingleTracker instance = null;
    private MemTracker tracker = new MemTracker();

    private SingleTracker() {

    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return this.tracker.add(item);
    }

    public Item findById(int id) {
        return this.tracker.findById(id);
    }

    public List<Item> findByName(String name) {
        return this.tracker.findByName(name);
    }

    public List<Item> findAll() {
        return this.tracker.findAll();
    }

    public boolean replace(int id, Item item) {
        return this.tracker.replace(id, item);
    }

    public void delete(int id) {
        this.tracker.delete(id);
    }
}
