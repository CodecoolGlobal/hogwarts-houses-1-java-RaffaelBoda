package com.codecool.hogwartshouses.controller;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.service.RoomService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/rooms")
public class RoomsController {
    private final RoomService roomService;
    private final Gson gson;

    @Autowired
    public RoomsController(RoomService roomService, Gson gson) {
        this.gson = gson;
        this.roomService = roomService;
    }

    @GetMapping(produces = "application/json")
    public String getRooms() {
        List<Room> rooms = roomService.getAll();
        return gson.toJson(rooms);
    }

    @PostMapping
    public void addRoom(@RequestParam int size) {
        Room room = new Room(size);
        roomService.add(room);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public String getRoomById(@PathVariable int id) {
        Optional<Room> or = roomService.getById(id);
        if (or.isPresent()) {
            return gson.toJson(or.get());
        } else {
            return "room not found";
        }
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public String deleteRoom(@PathVariable int id){
        if (roomService.getById(id).isPresent()) {
            roomService.delete(id);
            return "room " + id + " deleted";
        } else {
            return "there is no room " + id;
        }
    }

    @PutMapping(value = "{id}", produces = "application/json")
    public String updateRoom(@PathVariable int id) {
        if (roomService.getById(id).isPresent()) {
            roomService.renovate(id);
            return "room " + id + " renovated";
        } else {
            return "room " + id + " not found";
        }
    }

    @GetMapping(value = "/available", produces = "application/json")
    public String getAvailableRooms() {
        return gson.toJson(roomService.getAvailable());
    }

    @GetMapping(value = "/rat-owners", produces = "application/json")
    public String getRoomWithoutCatsOrOwls() {
        return gson.toJson(roomService.getRoomsWithoutCatsOrOwls());
    }
}