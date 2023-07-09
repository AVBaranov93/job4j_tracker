package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("bus driving");
    }

    @Override
    public void passengers(int amount) {
        System.out.println(amount + " passengers taken on board");
    }

    @Override
    public int fillIn(int fuel) {
        return fuel * 50;
    }
}
