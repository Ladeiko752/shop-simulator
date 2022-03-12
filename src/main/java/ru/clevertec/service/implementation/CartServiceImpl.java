package ru.clevertec.service.implementation;

import ru.clevertec.dao.CartRepository;
import ru.clevertec.dao.ProductRepository;
import ru.clevertec.dto.CartItemsDto;
import ru.clevertec.entity.Cart;
import ru.clevertec.entity.Product;
import ru.clevertec.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;

    @Autowired
    public CartServiceImpl(ProductRepository productRepository, CartRepository cartRepository) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
    }
    @Override
    public List<Cart> allItemsInCart(){
        return cartRepository.findAll();
    }

    @Override
    public void addProductInCart(int id, Cart cart, String username, int number) throws Exception {
        Product product = productRepository.getById(id);
        if (product == null){
            throw new Exception("product not found!");
        }
        cart.setProduct(product);
        cart.setCartItemPrice(product.getPrice());
        cart.setUsername(username);
        cart.setNumber(number);
        cart.setCartItemFinalPrice(product.getPrice()*number);
        cartRepository.save(cart);
    }

    public void updateProductPriceInCart(Cart cart){
        cartRepository.save(cart);
    }

    @Override
    public void deleteItemsFromCart(int id){
        cartRepository.deleteById(id);
    }

    @Override
    public CartItemsDto getCartItems(String username){
        int totalPrice = 0;
        List<Cart> allItems = new ArrayList<>();
        allItems = allItemsInCart();
        List<Cart> itemsInCart = new ArrayList<>();

        for (Cart cart: allItems){
            if (username.equals(cart.getUsername())){
                itemsInCart.add(cart);
                /*Если пользователь покупает более 5 единиц одного товара, то ему
                * предоставляется скидка в размере 10% общей стоимости*/
                if (cart.getNumber() > 5){
                    totalPrice += cart.getCartItemPrice() * 0.90 * cart.getNumber();
                }else{
                    totalPrice += (cart.getCartItemPrice() * cart.getNumber());
                }
            }
        }
        return new CartItemsDto(itemsInCart, totalPrice);
    }

}
