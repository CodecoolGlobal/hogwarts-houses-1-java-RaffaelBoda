package com.codecool.hogwartshouses.model;

import com.codecool.hogwartshouses.model.types.PetType;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Room {
    private static long currentId = 0;
    private final long id;
    private final int capacity;
    private final Set<Student> students;
    private boolean hasBeenRenovated;

    public Room(int capacity) {
        this.capacity = capacity;
        id = currentId;
        currentId++;
        students = new HashSet<>();
    }

    public void addStudent(Student student) {
        if (students.size() < capacity) {
            students.add(student);
        } else {
            System.out.println("Room is full");
        }

    }

    public long getId() {
        return id;
    }

    public void setHasBeenRenovated(boolean hasBeenRenovated) {
        this.hasBeenRenovated = hasBeenRenovated;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public boolean isHasBeenRenovated() {
        return hasBeenRenovated;
    }

    public int getCapacity() {
        return capacity;
    }
}
