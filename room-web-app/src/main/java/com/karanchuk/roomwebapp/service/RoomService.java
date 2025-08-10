package com.karanchuk.roomwebapp.service;

import com.karanchuk.roomwebapp.data.entity.RoomEntity;
import com.karanchuk.roomwebapp.data.repository.RoomRepository;
import com.karanchuk.roomwebapp.web.model.Room;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll().stream()
                .map(this::getRoomFromEntity)
                .toList();
    }

    public Room getRoomById(UUID id) throws BadRequestException {
        return roomRepository.findById(id)
                .map(this::getRoomFromEntity)
                .orElseThrow(() -> getBadRequestException(id));
    }

    public Room createRoom(Room room) {
        return getRoomFromEntity(roomRepository.save(getRoomEntityFromRoom(room)));
    }

    public Room updateRoom(Room room) throws BadRequestException {
        RoomEntity roomEntity = roomRepository.findById(room.getId())
                .orElseThrow(() -> getBadRequestException(room.getId()));
        roomEntity.setName(roomEntity.getName());
        roomEntity.setNumber(roomEntity.getNumber());
        roomEntity.setBedInfo(roomEntity.getBedInfo());
        return getRoomFromEntity(roomRepository.save(roomEntity));
    }

    public void deleteRoomById(UUID id) throws BadRequestException {
        RoomEntity roomEntity = roomRepository.findById(id)
                .orElseThrow(() -> getBadRequestException(id));
        roomRepository.delete(roomEntity);
    }

    private static BadRequestException getBadRequestException(UUID id) {
        String errorMsg = String.format("Room by ID %s isn't found", id);
        return new BadRequestException(errorMsg);
    }

    private Room getRoomFromEntity(RoomEntity entity) {
        return new Room(entity.getRoomId(), entity.getName(), entity.getNumber(), entity.getBedInfo());
    }

    private RoomEntity getRoomEntityFromRoom(Room room) {
        return new RoomEntity(room.getId(), room.getName(), room.getNumber(), room.getInfo());
    }
}
