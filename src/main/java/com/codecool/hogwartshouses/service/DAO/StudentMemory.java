package com.codecool.hogwartshouses.service.DAO;

import com.codecool.hogwartshouses.model.Student;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class StudentMemory implements Dao<Student>{
    private final Set<Student> students;

    public StudentMemory() {
        this.students = new HashSet<>();
    }

    @Override
    public Optional<Student> get(long id) {
        return students.stream().filter(student -> student.getId() == id).findFirst();
    }

    @Override
    public List<Student> getAll() {
        return new ArrayList<>(students).stream()
                .sorted(Comparator.comparing(Student::getId))
                .collect(Collectors.toList());
    }

    @Override
    public void add(Student student) {
        students.add(student);
    }

    @Override
    public void delete(long id) {
        students.removeIf(student -> student.getId() == id);
    }
}
