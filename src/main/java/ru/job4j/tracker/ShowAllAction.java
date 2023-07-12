package ru.job4j.tracker;

public class ShowAllAction implements UserAction {
    private final Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Show all items ===");
        Item[] items = tracker.findAll();
        if (items.length == 0) {
            out.println("Storage is empty");
        } else {
            out.println("Список всех заявок:");
            for (Item item : tracker.findAll()) {
                out.println(item);
            }
        }
        return true;
    }
}
