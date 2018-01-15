package pl.kedzierski.gameshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.kedzierski.gameshop.models.AvailabilityType;
import pl.kedzierski.gameshop.models.Product;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

@Controller
public class ProductController {

    @RequestMapping(value = "/exampleProduct", method = RequestMethod.GET)
    public String getExampleProduct(Model model){
        Product p = new Product(1, "Initial D Special Stage", LocalDate.of(2003, Month.JUNE, 26),
                new BigDecimal(29.99), new AvailabilityType(1, "Dostępne 24h", true), "Initial D Special Stage is also the first home-console Initial D game published by Sega.\n" +
                "Initial D Special Stage contains a story mode that allows the player to reenact racing scenes from the Initial D manga series, " +
                "as well as several new courses then not seen in the arcade versions of the game. " +
                "Bunta's Challenge is noticeably absent in the game. Additional features including replays for saved time-attack records and Iketani's car introduction.", "Konsola Playstation 2");
        model.addAttribute("product", p);
        return "/product";
    }

}
