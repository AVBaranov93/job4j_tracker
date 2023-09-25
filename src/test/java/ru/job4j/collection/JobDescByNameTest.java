package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JobDescByNameTest {
    @Test
    public void whenFirstNameMoreThanSecondThenNegative() {
        int rsl = new JobDescByName().compare(new Job("task3", 3),
                new Job("task1", 1));
        assertThat(rsl).isLessThan(0);
    }

}