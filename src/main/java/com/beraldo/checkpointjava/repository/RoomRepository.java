package com.beraldo.checkpointjava.repository;

import com.beraldo.checkpointjava.persistence.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
