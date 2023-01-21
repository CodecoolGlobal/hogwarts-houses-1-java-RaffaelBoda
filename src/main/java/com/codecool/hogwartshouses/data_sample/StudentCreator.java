package com.codecool.hogwartshouses.data_sample;

import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.model.types.PetType;
import com.codecool.hogwartshouses.service.DAO.RoomMemory;
import com.codecool.hogwartshouses.service.DAO.StudentMemory;
import com.codecool.hogwartshouses.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class StudentCreator {
    StudentMemory studentMemory;
    RoomService roomService;

    public void initialize() {
        Student hermione = new Student("Hermione", PetType.CAT, HouseType.GRYFFINDOR);
        Student draco = new Student("Draco", PetType.RAT, HouseType.SLYTHERIN);
        studentMemory.add(hermione);
        studentMemory.add(draco);
        roomService.getById(0).get().addStudent(hermione);
        roomService.getById(1).get().addStudent(draco);
    }

    @Autowired
    public StudentCreator(StudentMemory studentMemory, RoomService roomService) {
        this.studentMemory = studentMemory;
        this.roomService = roomService;
        initialize();
    }
}
