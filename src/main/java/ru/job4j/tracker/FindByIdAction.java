package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by id";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Find item by id ===");
        int id = input.askInt("enter id ");
        Item item = tracker.findById(id);
        if (item != null) {
            out.println("ваша заявка: " + item);
        } else {
            out.println("заявка не найдена");
        }
        return true;
    }
}
