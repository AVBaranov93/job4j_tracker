package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biConsumer = (i, s) -> map.put(i, s);

        biConsumer.accept(1, "one");
        biConsumer.accept(2, "two");
        biConsumer.accept(3, "three");
        biConsumer.accept(4, "four");
        biConsumer.accept(5, "five");
        biConsumer.accept(6, "six");
        biConsumer.accept(7, "seven");

        BiPredicate<Integer, String> biPredicate = (i, s) -> i % 2 == 0 || s.length() == 4;
        for (Integer key : map.keySet()) {
            if (biPredicate.test(key, map.get(key))) {
                System.out.println("key: " + key + " value: " + map.get(key));
            }
        }
        Supplier<List<String>> supplier = () -> new ArrayList<>(map.values());
        Consumer<String> consumer = (s) -> System.out.println(s);
        Function<String, String> function = (s) -> s.toUpperCase();
        for (String str : supplier.get()) {
            consumer.accept(function.apply(str));
        }
    }
}
