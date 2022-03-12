package ru.clevertec.controller;

import ru.clevertec.service.implementation.DiscountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class DiscountController {
    private final DiscountServiceImpl discountService;

    @Autowired
    public DiscountController(DiscountServiceImpl discountService) {
        this.discountService = discountService;
    }

    @PostMapping("/discount")
    public String activatePromoCode(@RequestParam("promo") String promo, Principal principal) throws Exception {
        discountService.activatePromoCode(promo, principal.getName());
        return "redirect:/cart";
    }
}
