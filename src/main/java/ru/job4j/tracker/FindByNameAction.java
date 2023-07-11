package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = tracker.findByName(input.askStr("enter name "));
        if (items.length > 0) {
            System.out.println("найденные заявки:");
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("заявки с таким именем отсутствуют");
        }
        return true;
    }
}
