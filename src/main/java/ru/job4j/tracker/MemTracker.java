package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MemTracker implements Store {
    private final List<Item> items = new ArrayList<>();
    private int itemId = 1;

    @Override
    public Item add(Item item) {
        item.setId(itemId++);
        items.add(item);
        return item;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (id == items.get(index).getId()) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    @Override
    public Item findById(int id) {
        int index = indexOf(id);
        return index  == -1 ? null : items.get(index);

    }

    @Override
    public List<Item> findByName(String name) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (name.equals(item.getName())) {
                result.add(item);
            }
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        return List.copyOf(items);
    }

    @Override
    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean result = index != -1;
        item.setId(id);
        if (result) {
            items.set(index, item);
        }
        return result;
    }

    @Override
    public void delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            items.remove(index);
            System.out.println("заявка удалена");
        } else {
            System.out.println("Ошибка удаления заявки");
        }
    }

    @Override
    public void close() throws Exception {

    }
}