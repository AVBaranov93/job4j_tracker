package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball ball = new Ball();
        new Hare().tryEat(ball);
        new Wolf().tryEat(ball);
        new Fox().tryEat(ball);
    }
}
