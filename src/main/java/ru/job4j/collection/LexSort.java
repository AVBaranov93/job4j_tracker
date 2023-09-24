package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        Integer leftValue = Integer.parseInt(left.split("\\.")[0]);
        Integer rightValue = Integer.parseInt(right.split("\\.")[0]);
        return Integer.compare(leftValue, rightValue);
    }
}
