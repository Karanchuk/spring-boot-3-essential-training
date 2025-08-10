package com.karanchuk.roomwebapp.web.controller;

import com.karanchuk.roomwebapp.data.entity.RoomEntity;
import com.karanchuk.roomwebapp.data.repository.RoomRepository;
import com.karanchuk.roomwebapp.service.RoomService;
import com.karanchuk.roomwebapp.web.model.Room;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/rooms")
public class RoomController {
    private final RoomRepository roomRepository;
    private final RoomService roomService;

    public RoomController(RoomRepository roomRepository, RoomService roomService) {
        this.roomRepository = roomRepository;
        this.roomService = roomService;
    }

    @GetMapping
    public String getRoomsPage(Model model) {
        List<RoomEntity> roomEntities = roomRepository.findAll();
        List<Room> rooms = new ArrayList<>(roomEntities.size());
        roomEntities.forEach(e -> rooms.add(new Room(e.getRoomId(), e.getName(), e.getNumber(), e.getBedInfo())));
        model.addAttribute("rooms", rooms);
        return "rooms";
    }

    @GetMapping(path = "/v2")
    public String getRoomsPageV2(Model model) {
        model.addAttribute("rooms", roomService.getAllRooms());
        return "rooms";
    }

}
