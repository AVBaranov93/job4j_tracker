package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        List<String> left = Arrays.asList(o1.split("/"));
        List<String> right = Arrays.asList(o2.split("/"));
        int result = right.get(0).compareTo(left.get(0));
        if (result != 0) {
            return result;
        }
        for (int i = 0; i < Math.min(left.size(), right.size()); i++) {
            int rsl = left.get(i).compareTo(right.get(i));
           if (rsl != 0) {
               return rsl;
           }
        }
        return Integer.compare(left.size(), right.size());
    }
}
