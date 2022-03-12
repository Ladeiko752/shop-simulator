package ru.clevertec.service;

import ru.clevertec.dto.CartItemsDto;
import ru.clevertec.entity.Cart;

import java.util.List;

public interface CartService {
    public List<Cart> allItemsInCart();
    public void addProductInCart(int id, Cart cart, String username, int number) throws Exception;
    public void deleteItemsFromCart(int id);
    public CartItemsDto getCartItems(String username);
}
