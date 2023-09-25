package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JobDescByPriorityTest {
    @Test
    public void whenFirstPriorityLessThanSecondThenPositive() {
        int rsl = new JobDescByPriority().compare(new Job("task1", 3),
                new Job("task2", 7));
        assertThat(rsl).isGreaterThan(0);
    }

}