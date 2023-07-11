package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("enter id ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("ваша заявка: " + item);
        } else {
            System.out.println("заявка не найдена");
        }
        return true;
    }
}
