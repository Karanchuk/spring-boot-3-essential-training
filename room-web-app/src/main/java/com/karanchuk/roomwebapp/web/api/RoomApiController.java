package com.karanchuk.roomwebapp.web.api;

import com.karanchuk.roomwebapp.service.RoomService;
import com.karanchuk.roomwebapp.web.model.Room;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/rooms")
public class RoomApiController {
    private final RoomService roomService;

    public RoomApiController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable(name = "id") UUID id) throws BadRequestException {
        return roomService.getRoomById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // returned 201 status instead of 200
    public Room createRoom(@RequestBody Room room) {
        return roomService.createRoom(room);
    }

    @PutMapping
    public Room updateRoom(@RequestBody Room room) throws BadRequestException {
        return roomService.updateRoom(room);
    }

    @DeleteMapping("/{id}")
    public void deleteRoomById(@PathVariable(name = "id") UUID id) throws BadRequestException {
        roomService.deleteRoomById(id);
    }
}
