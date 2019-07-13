package ru.example.templatethymeleaf.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class Order {
    private String orderNumber;
    private String date;
    private User customer;
    private Map<Product, Integer> shoppingCart;

    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (Map.Entry<Product, Integer> entry : shoppingCart.entrySet()) {
            totalPrice += entry.getKey().getPrice() * entry.getValue();
        }
        return totalPrice;
    }

    public Set<Product> getRecommendations(int limit) {
        Set<Product> recommendations = new HashSet<>();
        for (Product product : shoppingCart.keySet()) {
            recommendations.addAll(product.getRecomendations());
        }
        return recommendations.stream()
                .sorted((o1, o2) -> o2.getRating() - o1.getRating())
                .limit(limit)
                .collect(Collectors.toSet());
    }
}
