package ru.clevertec.dao;

import ru.clevertec.entity.DiscountCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountCartRepository extends JpaRepository<DiscountCart, Integer> {
    DiscountCart findByPromoCode(String promoCode);
}
