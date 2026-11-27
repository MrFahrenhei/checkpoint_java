package com.beraldo.checkpointjava.service;

import com.beraldo.checkpointjava.dto.RoomResponse;
import com.beraldo.checkpointjava.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<RoomResponse> getAllRooms(){
        return roomRepository.findAll().stream().map(RoomResponse::new).toList();
    }
}
