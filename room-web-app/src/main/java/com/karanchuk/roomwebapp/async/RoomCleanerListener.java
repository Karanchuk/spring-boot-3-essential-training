package com.karanchuk.roomwebapp.async;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.karanchuk.roomwebapp.service.RoomService;
import com.karanchuk.roomwebapp.web.model.Room;
import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RoomCleanerListener {
    private static final Logger LOG = LoggerFactory.getLogger(RoomCleanerListener.class);
    private final ObjectMapper objectMapper;
    private final RoomService roomService;

    public RoomCleanerListener(ObjectMapper objectMapper, RoomService roomService) {
        this.objectMapper = objectMapper;
        this.roomService = roomService;
    }

    public void receiveMessage (String message) {
        try {
            AsyncPayload payload = objectMapper.readValue(message, AsyncPayload.class);
            if ("ROOM".equals(payload.getModel())) {
                Room room = roomService.getRoomById(payload.getId());
                LOG.info("Room {}:{} needs to be cleaned!", room.getNumber(), room.getName());
            } else {
                LOG.warn("Unknown model type: {}", payload.getModel());
            }
        } catch (JsonProcessingException | BadRequestException e) {
            e.printStackTrace();
        }
    }
}
