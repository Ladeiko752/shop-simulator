package ru.clevertec.controller;

import ru.clevertec.annotations.validation.CheckPriceValidator;
import ru.clevertec.entity.Product;
import ru.clevertec.service.implementation.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    private final ProductServiceImpl productService;

    @Autowired
    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String getAllProducts(Model model){
        List<Product> allProducts = productService.getListOfProducts();
        List<Product> buff = new ArrayList<>();

        for (Product product : allProducts){
            if (!product.getBrand().matches("(^([A-Z]|[А-Я]))+(([a-z]|[а-я]){2,29}$)")
                    || !product.getPrice().toString().matches("^([1-9])?([0-9]\\b)\\.([0-9]{2}$)")){
                try(FileWriter writer = new FileWriter("valid.txt", true))
                {
                    writer.write("The database contains an incorrect product value: " + product.toString());
                    writer.append('\n');
                    writer.flush();
                    buff.add(product);
                }
                catch(IOException ex){
                    System.out.println(ex.getMessage());
                }
            }
        }

        for (Product product : buff){
            allProducts.remove(product);
            productService.deleteProduct(product.getId());
        }

        model.addAttribute("products", allProducts);
        return "view_products";
    }

    @GetMapping("/products/{id}")
    public String getProductOnId(@PathVariable int id, Model model) throws Exception {
        Product product = productService.getProductOnId(id);
        model.addAttribute("prodFoundById", product);
        return "view_product_on_id";
    }

    @GetMapping("/products/category/{category}")
    public String getProductsByCategories(@PathVariable String category, Model model){
        List<Product> sortedProduct = productService.getProductsByCategory(category);
        model.addAttribute("prodByCategory", sortedProduct);
        return "view_sorted_product";
    }

    @GetMapping("/adding")
    public String addProduct(Model model){
        Product product = new Product();
        model.addAttribute("productForAdding", product);
        return "view_form_for_add_product";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("productForAdding") Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
        return "redirect:/products";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable int id, Model model) throws Exception {
        Product product = productService.getProductOnId(id);
        model.addAttribute("productForAdding", product);
        return "view_form_for_add_product";
    }

}
