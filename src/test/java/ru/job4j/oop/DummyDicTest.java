package ru.job4j.oop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DummyDicTest {

    @Test
    void whenStringHello() {
        String in = "Hello";
        String expected = "Неизвестное слово. Hello";
        String out = new DummyDic().engToRus(in);
        assertThat(out).isEqualTo(expected);
    }
}