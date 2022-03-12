package ru.clevertec.dto;

import ru.clevertec.entity.Cart;

import java.util.List;

public class CartItemsDto {
    private List<Cart> items;
    private int price;

    public CartItemsDto(List<Cart> items, int price) {
        this.items = items;
        this.price = price;
    }

    public List<Cart> getItems() {
        return items;
    }

    public void setItems(List<Cart> items) {
        this.items = items;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
