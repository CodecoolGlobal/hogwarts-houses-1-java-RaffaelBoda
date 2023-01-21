package com.codecool.hogwartshouses.model;

import com.codecool.hogwartshouses.model.types.HouseType;
import com.codecool.hogwartshouses.model.types.PetType;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Student {
    private static long currentId = 0;
    private final long id;
    private final String name;
    private final PetType pet;
    private final HouseType house;

    public Student(String name, PetType pet, HouseType house) {
        id = currentId;
        this.name = name;
        this.pet = pet;
        this.house = house;
        currentId++;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PetType getPet() {
        return pet;
    }

    public HouseType getHouse() {
        return house;
    }
}
