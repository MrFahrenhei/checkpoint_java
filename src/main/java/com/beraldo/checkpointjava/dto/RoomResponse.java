package com.beraldo.checkpointjava.dto;

import com.beraldo.checkpointjava.persistence.entity.Room;

public record RoomResponse(Long id, int capacity ) {
    public RoomResponse(Room room){

    }
}
