package ru.job4j.tracker;

public final class SingleTracker {
    private static SingleTracker instance = null;
    private Tracker tracker = new Tracker();

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

    public Item[] findByName(String name) {
        return this.tracker.findByName(name);
    }

    public Item[] findAll() {
        return this.tracker.findAll();
    }

    public boolean replace(int id, Item item) {
        return this.tracker.replace(id, item);
    }

    public boolean delete(int id) {
        return this.tracker.delete(id);
    }
}
