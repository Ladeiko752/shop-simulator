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
    private Double cartItemPrice;
    @Column(name = "username")
    private String username;
    @Column(name = "number")
    private Integer number;
    @Column(name = "final_price")
    private Double cartItemFinalPrice;

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

    public Double getCartItemPrice() {
        return cartItemPrice;
    }

    public void setCartItemPrice(Double cartItemPrice) {
        this.cartItemPrice = cartItemPrice;
    }

    public Double getCartItemFinalPrice() {
        return cartItemFinalPrice;
    }

    public void setCartItemFinalPrice(Double cartItemFinalPrice) {
        this.cartItemFinalPrice = cartItemFinalPrice;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getNumber() { return number;}

    public void setNumber(Integer number) { this.number = number;}
}
