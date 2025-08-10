package com.karanchuk.roomwebapp.data.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "ROOMS")
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ROOM_ID")
    private UUID roomId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "NUMBER")
    private String number;

    @Column(name = "BED_INFO")
    private String bedInfo;

    public RoomEntity(UUID roomId, String name, String number, String bedInfo) {
        this.roomId = roomId;
        this.name = name;
        this.number = number;
        this.bedInfo = bedInfo;
    }

    public RoomEntity() {}

    public UUID getRoomId() {
        return roomId;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getBedInfo() {
        return bedInfo;
    }

    public void setRoomId(UUID roomId) {
        this.roomId = roomId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setBedInfo(String bedInfo) {
        this.bedInfo = bedInfo;
    }
}
