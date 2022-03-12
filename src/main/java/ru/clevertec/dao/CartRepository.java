package ru.clevertec.dao;

import ru.clevertec.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    Cart findByUsername(String username);
}
