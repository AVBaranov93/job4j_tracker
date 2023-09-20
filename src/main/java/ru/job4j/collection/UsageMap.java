package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("111@mail.ru", "abdurahman abdulaevich");
        map.put("222@mail.ru", "abdulai abdurahmanovich");
        for (String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
    }
}
