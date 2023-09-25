package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JobAscByNameTest {
    @Test
    public void whenFirstNameMoreThanSecondThenPositive() {
        int rsl = new JobAscByName().compare(new Job("task7", 10),
                new Job("task2", 1));
        assertThat(rsl).isGreaterThan(0);
    }
}