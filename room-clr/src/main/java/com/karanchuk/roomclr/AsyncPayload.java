package com.karanchuk.roomclr;

import java.util.UUID;

public class AsyncPayload {
    private UUID id;
    private String model;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
