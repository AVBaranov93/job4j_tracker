package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> compareName = o -> o.getName().contains(key);
        Predicate<Person> compareSurname = o -> o.getSurname().contains(key);
        Predicate<Person> comparePhone = o -> o.getPhone().contains(key);
        Predicate<Person> compareAddress = o -> o.getAddress().contains(key);
        Predicate<Person> combine = compareName.or(compareSurname).or(comparePhone).or(compareAddress);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}

