package com.beraldo.checkpointjava.controller;

import com.beraldo.checkpointjava.dto.RoomRequest;
import com.beraldo.checkpointjava.dto.RoomResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {
    //CRUD
    //C create
    @PostMapping
    public ResponseEntity<RoomResponse> register(@RequestBody @Valid RoomRequest request){
        //TODO cria uma room e retorna 200
    }
    //R read (all)
    @GetMapping
    public ResponseEntity<List<RoomResponse>> getAllRooms(){
        //TODO retorna todas as rooms
    }
    //R read (one)
    @GetMapping("/{id}")
    public ResponseEntity<RoomResponse> getOneRoom(@PathVariable Long roomId){
        //TODO retorna uma room e código 200
    }

    //U update
    @PutMapping("/{id}")
    public ResponseEntity<RoomResponse> updateRoom(@PathVariable Long roomId){
        //TODO update então retorna a nova room e código 200
    }

    //D delete (kind)
    @PatchMapping("/{id}")
    public ResponseEntity<String> removeRoom(@PathVariable Long roomId){
        //TODO Change status and return ok
        return ResponseEntity.ok().build();
    }

}
