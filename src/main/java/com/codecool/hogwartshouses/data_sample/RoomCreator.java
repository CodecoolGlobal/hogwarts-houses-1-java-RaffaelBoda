package com.codecool.hogwartshouses.data_sample;

import com.codecool.hogwartshouses.model.Room;
import com.codecool.hogwartshouses.service.DAO.RoomMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomCreator {
    RoomMemory roomMemory;

    @Autowired
    public RoomCreator(RoomMemory roomMemory) {
        this.roomMemory = roomMemory;
        initialize();
    }

    private void initialize() {
        Room room1 = new Room(2);
        Room room2 = new Room(3);

        roomMemory.add(room1);
        roomMemory.add(room2);
    }
}
