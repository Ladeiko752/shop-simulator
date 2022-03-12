package ru.clevertec.entity;

import javax.persistence.*;

@Entity
@Table(name = "discount_сard")
public class DiscountCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "promo_code")
    private String promoCode;
    @Column(name = "discount")
    private double discount;

    public DiscountCart() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
