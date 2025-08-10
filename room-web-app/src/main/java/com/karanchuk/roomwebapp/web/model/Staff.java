package com.karanchuk.roomwebapp.web.model;

import com.karanchuk.roomwebapp.data.entity.Position;
import org.springframework.util.StringUtils;

import java.util.Locale;
import java.util.UUID;

public class Staff {
    private UUID id;
    private String lastName;
    private String firstName;
    private String position;

    public Staff(UUID id, String lastName, String firstName, Position position) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.position = StringUtils.capitalize(position.toString().toLowerCase(Locale.ROOT));
    }

    public UUID getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPosition() {
        return position;
    }
}
