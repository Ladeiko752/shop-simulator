package ru.clevertec.service;

import ru.clevertec.entity.Product;

import java.util.List;


public interface ProductService {
    public List<Product> getListOfProducts();
    public Product getProductOnId(int id) throws Exception;
    public List<Product> getProductsByCategory(String category);
    public void saveProduct(Product product);
    public void deleteProduct(int id);
}
