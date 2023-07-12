package ru.job4j.tracker;

public class ShowAllAction implements UserAction {
    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        if (items.length == 0) {
            System.out.println("Storage is empty");
        } else {
            for (Item item : tracker.findAll()) {
                System.out.println(item);
            }
        }
        return true;
    }
}
