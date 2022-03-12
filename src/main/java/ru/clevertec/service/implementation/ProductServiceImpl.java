package ru.clevertec.service.implementation;

import ru.clevertec.dao.ProductRepository;
import ru.clevertec.entity.Product;
import ru.clevertec.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getListOfProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductOnId(int id) throws Exception {
        Product product = null;
        Optional<Product> optional = productRepository.findById(id);
        /*Проверка на существование товара в базе данны*/
        if (optional.isPresent()){
            product = optional.get();
        }else {
            throw new Exception("Product does not exist");
        }
        return product;
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }


    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
