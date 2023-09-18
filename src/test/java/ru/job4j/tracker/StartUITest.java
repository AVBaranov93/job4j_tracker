package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                Arrays.asList("0", "Item name", "1")
        );
        Tracker tracker = new Tracker();
        Output out = new ConsoleOutput();
        List<UserAction> actions = Arrays.asList(
                new CreateAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("Item name");
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Output out = new ConsoleOutput();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                Arrays.asList("0", String.valueOf(item.getId()), replacedName, "1")
        );
        List<UserAction> actions = Arrays.asList(
                new EditAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Output out = new ConsoleOutput();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                Arrays.asList("0", String.valueOf(item.getId()), "1")
        );
        List<UserAction> actions = Arrays.asList(
                new DeleteAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOut();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                Arrays.asList("0", String.valueOf(one.getId()), replaceName, "1")
        );
        List<UserAction> actions = Arrays.asList(
                new EditAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit" + ln
                        + "=== Edit item ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit" + ln
                        + "=== Exit ===" + ln
        );
    }

    @Test
    void whenFindItemByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("New Item"));
        Output out = new StubOut();
        List<UserAction> actions = Arrays.asList(new FindByNameAction(out), new ExitAction(out));
        Input input = new StubInput(Arrays.asList("0", item.getName(), "1"));
        String ln = System.lineSeparator();
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Find item by name" + ln
                        + "1. Exit" + ln
                        + "=== Find item by name ===" + ln
                        + "найденные заявки:" + ln
                        + item + ln
                        + "Menu:" + ln
                        + "0. Find item by name" + ln
                        + "1. Exit" + ln
                        + "=== Exit ===" + ln
        );
    }

    @Test
    void whenFindItemById() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("New Item"));
        Output out = new StubOut();
        List<UserAction> actions = Arrays.asList(new FindByIdAction(out), new ExitAction(out));
        Input input = new StubInput(Arrays.asList("0", String.valueOf(item.getId()), "1"));
        String ln = System.lineSeparator();
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit" + ln
                        + "=== Find item by id ===" + ln
                        + "ваша заявка: " + item + ln
                        + "Menu:" + ln
                        + "0. Find item by id" + ln
                        + "1. Exit" + ln
                        + "=== Exit ===" + ln
        );
    }

    @Test
    void whenShowAllItems() {
        Tracker tracker = new Tracker();
        Item one = new Item("one");
        Item two = new Item("two");
        tracker.add(one);
        tracker.add(two);
        Output out = new StubOut();
        List<UserAction> actions = Arrays.asList(new ShowAllAction(out), new ExitAction(out));
        Input input = new StubInput(Arrays.asList("0", "1"));
        String ln = System.lineSeparator();
        new StartUI(out).init(input, tracker, actions);
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit" + ln
                        + "=== Show all items ===" + ln
                        + "Список всех заявок:" + ln
                        + one + ln
                        + two + ln
                        + "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit" + ln
                        + "=== Exit ===" + ln
        );
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOut();
        Input in = new StubInput(Arrays.asList("22", "0"));
        Tracker tracker = new Tracker();
        List<UserAction> actions = Collections.singletonList(
                new ExitAction(out)
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Exit" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu:" + ln
                        + "0. Exit" + ln
                        + "=== Exit ===" + ln
        );
    }

    @Test
    public void whenInvalidInput() {
        Output out = new StubOut();
        Input in = new StubInput(
                Arrays.asList("one", "1")
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOut();
        Input in = new StubInput(
                Collections.singletonList("1")
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenMultipleValidInputs() {
        Output out = new StubOut();
        Input in = new StubInput(
                Arrays.asList("0", "1", "2")
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(0);
        int selected1 = input.askInt("Enter menu:");
        assertThat(selected1).isEqualTo(1);
        int selected2 = input.askInt("Enter menu:");
        assertThat(selected2).isEqualTo(2);
    }

    @Test
    public void whenNegativeInput() {
        Output out = new StubOut();
        Input in = new StubInput(
                Collections.singletonList("-2")
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-2);
    }

    @Test
    void whenMenuItemIsNotNumber() {
        Tracker tracker = new Tracker();
        Output out = new StubOut();
        List<String> answers = Arrays.asList("zero", "0");
        Input input = new ValidateInput(out, new StubInput(answers));
        List<UserAction> actions = Collections.singletonList(new ExitAction(out));
        new StartUI(out).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu:" + ln
                        + "0. Exit" + ln
                        + "Please enter valid data" + ln
                        + "=== Exit ===" + ln
        );
    }
}