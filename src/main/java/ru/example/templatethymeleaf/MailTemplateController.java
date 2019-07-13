package ru.example.templatethymeleaf;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.example.templatethymeleaf.entities.Order;
import ru.example.templatethymeleaf.entities.Product;
import ru.example.templatethymeleaf.entities.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class MailTemplateController {

    @RequestMapping("/")
    public String mailTemplate(Model model) {

        User user = new User("Джейсон", "Стэйтем", false, 0);
        Product dice = new Product("Игральная кость", 5.5, null, 4);
        Product wallet = new Product("Кошелек", 17.6, null, 5);
        Product bullet = new Product("Патрон", 0.1, null, 7);
        Product card = new Product("Карты", 0.1, Arrays.asList(dice), 7);
        Product money = new Product("Деньги", 1.0, Arrays.asList(wallet), 10);
        Product weapon = new Product("Ствол", 1000.0, Arrays.asList(bullet), 6);

        String orderNumber = "TMP-" + LocalDate.now().getYear() + "0000001";
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        Map<Product, Integer> shoppingCart = new LinkedHashMap<>();
        shoppingCart.put(card, 52);
        shoppingCart.put(money, 100_000);
        shoppingCart.put(weapon, 2);

        Order order = new Order(orderNumber, date, user, shoppingCart);

        model.addAttribute("user", user);
        model.addAttribute("order", order);
        return "mailTemplate";
    }
}
