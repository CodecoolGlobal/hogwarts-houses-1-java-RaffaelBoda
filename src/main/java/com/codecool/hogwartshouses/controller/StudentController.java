package com.codecool.hogwartshouses.controller;

import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.service.DAO.StudentMemory;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;


@RestController
@RequestMapping("/students")
public class StudentController {
    private final Gson gson;
    private final StudentMemory studentMemory;

    @Autowired
    public StudentController(Gson gson, StudentMemory studentMemory) {
        this.gson = gson;
        this.studentMemory = studentMemory;
    }

    @GetMapping
    public String getAllStudents() {
        return gson.toJson(studentMemory.getAll());
    }
}