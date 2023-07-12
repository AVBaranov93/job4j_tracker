package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find item by name ===");
        Item[] items = tracker.findByName(input.askStr("enter name "));
        if (items.length > 0) {
            out.println("найденные заявки:");
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("заявки с таким именем отсутствуют");
        }
        return true;
    }
}
