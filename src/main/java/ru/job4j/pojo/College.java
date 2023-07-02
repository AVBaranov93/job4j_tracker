package ru.job4j.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Full Name");
        student.setGroup("1");
        student.setEntryDate(LocalDate.now());
        System.out.println("student: " + student.getFullName() + System.lineSeparator()
                + "Group: " + student.getGroup() + System.lineSeparator()
                + "Entry date: " + student.getEntryDate());
    }
}
