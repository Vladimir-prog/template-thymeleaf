package ru.example.templatethymeleaf.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private String firstName;
    private String lastName;
    private boolean registered;
    private int countOfBonuses;

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
