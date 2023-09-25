package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JobAscByPriorityTest {
    @Test
    public void whenFirstPriorityMoreThanSecondThenPositive() {
        int rsl = new JobAscByPriority().compare(new Job("task1", 2),
                new Job("task2", 1));
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenFirstPriorityLessThanSecondThenNegative() {
        int rsl = new JobAscByPriority().compare(new Job("task1", 2),
                new Job("task2", 12));
        assertThat(rsl).isLessThan(0);
    }

}