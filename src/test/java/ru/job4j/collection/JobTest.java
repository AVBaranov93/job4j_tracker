package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

class JobTest {
    @Test
    public void whenAscCompareByNameAndPriority() {
        Job task1 = new Job("task1", 3);
        Job task2 = new Job("task1", 2);
        Comparator<Job> comparator = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = comparator.compare(task1, task2);
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenDscCompareByNameAndPriority() {
        Job task1 = new Job("task1", 3);
        Job task2 = new Job("task1", 12);
        Comparator<Job> comparator = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = comparator.compare(task1, task2);
        assertThat(rsl).isGreaterThan(0);
    }
}