package com.beraldo.checkpointjava.controller;

import com.beraldo.checkpointjava.dto.RoomRequest;
import com.beraldo.checkpointjava.dto.RoomResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {
    @PostMapping
    public ResponseEntity<RoomResponse> register(@RequestBody RoomRequest request){

    }
}
