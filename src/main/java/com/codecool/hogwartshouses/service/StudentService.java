package com.codecool.hogwartshouses.service;

import com.codecool.hogwartshouses.service.DAO.StudentMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    StudentMemory studentMemory;

    @Autowired
    public StudentService(StudentMemory studentMemory) {
        this.studentMemory = studentMemory;
    }
}
