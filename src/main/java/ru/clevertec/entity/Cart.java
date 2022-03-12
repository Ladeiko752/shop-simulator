package ru.clevertec.entity;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "price")
    private int cartItemPrice;
    @Column(name = "username")
    private String username;
    @Column(name = "number")
    private int number;
    @Column(name = "final_price")
    private int cartItemFinalPrice;

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCartItemPrice() {
        return cartItemPrice;
    }

    public void setCartItemPrice(int cartItemPrice) {
        this.cartItemPrice = cartItemPrice;
    }

    public int getCartItemFinalPrice() {
        return cartItemFinalPrice;
    }

    public void setCartItemFinalPrice(int cartItemFinalPrice) {
        this.cartItemFinalPrice = cartItemFinalPrice;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getNumber() { return number;}

    public void setNumber(int number) { this.number = number;}
}
