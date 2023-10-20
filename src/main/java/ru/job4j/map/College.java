package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {
    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        Optional<Student> student = Optional.empty();
        return students.keySet()
                .stream()
                .filter(s -> s.account().equals(account))
                .findFirst();
    }

    public Optional<Subject> findBySubjectName(String account, String name) {
       Optional<Student> student = findByAccount(account);
       if (student.isEmpty()) {
           return Optional.empty();
       }
            return students.get(student.get())
                    .stream()
                    .filter(s -> s.name().equals(name))
                    .findFirst();
    }
}
