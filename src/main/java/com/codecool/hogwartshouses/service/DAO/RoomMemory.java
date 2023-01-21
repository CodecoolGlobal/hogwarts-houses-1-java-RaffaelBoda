package com.codecool.hogwartshouses.service.DAO;

import com.codecool.hogwartshouses.model.Room;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class RoomMemory implements Dao<Room> {
    private final Set<Room> rooms;

    private RoomMemory() {
        rooms = new HashSet<>();
    }

    @Override
    public Optional<Room> get(long id) {
        return rooms.stream().filter(room -> room.getId() == id).findFirst();
    }

    @Override
    public List<Room> getAll() {
        ArrayList<Room> roomsList = new ArrayList<>(rooms);
        return roomsList.stream().sorted(Comparator.comparing(Room::getId)).collect(Collectors.toList());
    }

    @Override
    public void add(Room room) {
        rooms.add(room);
    }

    @Override
    public void delete(long id) {
        rooms.removeIf(room -> room.getId() == id);
    }
}
