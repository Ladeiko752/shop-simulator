package ru.clevertec.entity;

import org.intellij.lang.annotations.Pattern;
import ru.clevertec.annotations.CheckBrand;
import ru.clevertec.annotations.CheckPrice;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "category")
    private String category;
    @Column(name = "brand")
    @CheckBrand(value = "(((^[А-Я])([а-я]{2,29}$))|(^([A-Z])([a-z]{2,29}$)))")
    private String brand;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    @CheckPrice(value = "^([1-9])?([0-9]\\b)\\.([0-9]{2}$)")
    private Double price;

    public Product() {
    }

    public Product(String name, String category, String brand, String description, double price) {
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
