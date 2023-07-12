package ru.job4j.ex;

public class FactRec {
    public static int calc(int n) {
        if (n > 1) {
            return calc(n - 1) * n;
        }
        return 1;
    }

    public static void main(String[] args) {
        int rsl = calc(3);
        System.out.println(rsl);
    }
}
