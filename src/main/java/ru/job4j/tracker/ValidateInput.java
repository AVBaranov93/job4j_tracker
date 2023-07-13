package ru.job4j.tracker;

public class ValidateInput implements Input {
    private final Input input;
    private final Output out;

    public ValidateInput(Output out, Input input) {
        this.input = input;
        this.out = out;
    }

    @Override
    public String askStr(String question) {
        return this.input.askStr(question);
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = input.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                out.println("Please enter valid data");
            }
        } while (invalid);
        return value;
    }
}
