package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Delete item ===");
        int id = input.askInt("enter id to delete item ");
        if (tracker.delete(id)) {
            out.println("заявка удалена");
        } else {
            out.println("Ошибка удаления заявки");
        }
        return true;
    }
}
