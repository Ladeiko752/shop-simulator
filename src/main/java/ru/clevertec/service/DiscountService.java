package ru.clevertec.service;

public interface DiscountService {
    public void activatePromoCode(String promo, String username) throws Exception;
}
