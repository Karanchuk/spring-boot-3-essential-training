package com.karanchuk.roomwebapp.web.model;

import java.util.UUID;

public class Room {
    private UUID id;
    private String name;
    private String number;
    private String info;

    public Room(UUID id, String name, String number, String info) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.info = info;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getInfo() {
        return info;
    }
}
