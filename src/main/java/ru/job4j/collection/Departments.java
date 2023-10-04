package ru.job4j.collection;

import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            String[] rsl = value.split("/");
            for (int i = 0; i < rsl.length; i++) {
                if (i == 0) {
                    tmp.add(rsl[i]);
                    start = rsl[i];
                } else {
                    start = start + "/" + rsl[i];
                    tmp.add(start);
                }
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs, Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> orgs) {
        Collections.sort(orgs, new DepDescComp());
    }
}
