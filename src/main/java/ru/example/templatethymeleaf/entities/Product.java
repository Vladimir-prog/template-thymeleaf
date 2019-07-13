package ru.example.templatethymeleaf.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Product {
    public String productName;
    private double price;
    private List<Product> recomendations;
    private int rating;
}
