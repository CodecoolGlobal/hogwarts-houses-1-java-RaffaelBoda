package com.codecool.hogwartshouses.service;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.model.Student;
import com.codecool.hogwartshouses.model.types.PetType;
import com.codecool.hogwartshouses.service.DAO.RoomMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoomService {
    private RoomMemory roomMemory;

    @Autowired
    public RoomService(RoomMemory roomMemory) {
        this.roomMemory = roomMemory;
    }

    public List<Room> getAll() {
        return roomMemory.getAll();
    }

    public Optional<Room> getById(long id) {
        return roomMemory.get(id);
    }

    public void add(Room room) {
        roomMemory.add(room);
    }

    public void delete(long id) {
        roomMemory.delete(id);
    }

    public void renovate(long id) {
        Optional<Room> room = roomMemory.get(id);
        room.ifPresent(value -> value.setHasBeenRenovated(true));
    }

    public List<Room> getAvailable() {
        return roomMemory.getAll().stream()
                .filter(room -> room.getCapacity() > room.getStudents().size())
                .collect(Collectors.toList());
    }

    public List<Room> getRoomsWithoutCatsOrOwls() {
        List<Room> rooms = roomMemory.getAll();
        for (Room room : rooms) {
            for (Student student : room.getStudents()) {
                if (student.getPet().equals(PetType.OWL) || student.getPet().equals(PetType.CAT)) {
                    rooms.remove(room);
                }
            }
        }
        return rooms;
    }
}
