package com.karanchuk.roomclr;


import java.util.UUID;

public class Room {
    private UUID id;
    private String name;
    private String number;
    private String info;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Room{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", number='" + number + '\'' +
               ", info='" + info + '\'' +
               '}';
    }
}
