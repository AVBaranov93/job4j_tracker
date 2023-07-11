package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("enter id to delete item ");
        if (tracker.delete(id)) {
            System.out.println("заявка удалена");
        } else {
            System.out.println("Ошибка удаления заявки");
        }
        return true;
    }
}
