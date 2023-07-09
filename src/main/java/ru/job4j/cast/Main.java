package ru.job4j.cast;

public class Main {
    public static void main(String[] args) {
        Vehicle bus = new Bus();
        Vehicle train = new Train();
        Vehicle airplane = new Airplane();
        Vehicle bus1 = new Bus();
        Vehicle train1 = new Train();
        Vehicle airplane1 = new Airplane();
        Vehicle bus2 = new Bus();
        Vehicle train2 = new Train();
        Vehicle airplane2 = new Airplane();
        Vehicle[] vehicles = new Vehicle[] {bus, train, airplane, bus1, train1, airplane1, bus2, train2, airplane2};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
    }

}
