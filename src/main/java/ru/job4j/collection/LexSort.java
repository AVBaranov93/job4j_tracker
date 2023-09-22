package ru.job4j.collection;

import java.util.Comparator;
import java.util.regex.Pattern;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        Integer leftValue = Integer.parseInt(left.split(Pattern.quote("."))[0]);
        Integer rightValue = Integer.parseInt(right.split(Pattern.quote("."))[0]);
        return Integer.compare(leftValue, rightValue);
    }
}
