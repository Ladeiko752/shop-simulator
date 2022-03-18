package ru.clevertec.service.implementation;

import ru.clevertec.dao.CartRepository;
import ru.clevertec.dao.DiscountCartRepository;
import ru.clevertec.entity.Cart;
import ru.clevertec.entity.DiscountCart;
import ru.clevertec.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiscountServiceImpl implements DiscountService {
    private final DiscountCartRepository discountCartRepository;
    private final CartServiceImpl cartService;
    private final CartRepository cartRepository;

    @Autowired
    public DiscountServiceImpl(DiscountCartRepository discountCartRepository, CartServiceImpl cartService, CartRepository cartRepository){
        this.discountCartRepository = discountCartRepository;
        this.cartService = cartService;
        this.cartRepository = cartRepository;
    }

    @Override
    public void activatePromoCode(String promo, String username) throws Exception {
        DiscountCart discountCart = discountCartRepository.findByPromoCode(promo);
        if (discountCart != null){
            List<Cart> allItems = new ArrayList<>();
            allItems = cartService.allItemsInCart();
            List<Cart> itemsInCart = new ArrayList<>();
            for (Cart cart: allItems){
                if (username.equals(cart.getUsername())){
                    cart.setCartItemPrice((cart.getCartItemPrice()*discountCart.getDiscount()));
                    cart.setCartItemFinalPrice((cart.getCartItemFinalPrice()*discountCart.getDiscount()));
                    cartRepository.save(cart);
                }
            }
        }else
            throw new Exception("The entered promo code does not exist");
    }


}
