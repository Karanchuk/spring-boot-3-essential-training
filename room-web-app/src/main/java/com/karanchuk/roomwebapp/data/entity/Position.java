package com.karanchuk.roomwebapp.data.entity;

public enum Position {
    SECURITY, HOUSEKEEPING, FRONT_DESK, CONCIERGE;

    @Override
    public String toString() {
        return switch (this) {
            case SECURITY -> "SECURITY";
            case HOUSEKEEPING -> "HOUSEKEEPING";
            case FRONT_DESK -> "FRONT_DESK";
            case CONCIERGE -> "CONCIERGE";
        };
    }
}
