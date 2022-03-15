package ru.clevertec.controller;

import ru.clevertec.dto.CartItemsDto;
import ru.clevertec.entity.Cart;
import ru.clevertec.service.implementation.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.FileWriter;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {
    private final CartServiceImpl cartService;

    @Autowired
    public CartController(CartServiceImpl cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/buy/{id}")
    public String addToCart(@PathVariable int id, @ModelAttribute Cart cartItems, Principal principal, HttpServletRequest request/*, Model model*/) throws Exception {
        int number = Integer.parseInt(request.getParameter("number"));
        //model.addAttribute("number", number);
        if (number == 0){
            throw new Exception("Can't add zero items to cart");
        }
        cartService.addProductInCart(id, cartItems, principal.getName(), number);
        return "redirect:/products";
    }

    @GetMapping("/cart/delete/{id}")
    public String deleteFromCart(@PathVariable int id){
        cartService.deleteItemsFromCart(id);
        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String myCart (Principal principal, Model model){
        CartItemsDto cartItems = cartService.getCartItems(principal.getName());
        List<Cart> cartList = new ArrayList<>();
        for (Cart cart : cartItems.getItems()){
            if (!cart.getNumber().toString().matches("^([1-9]$|([1]\\d$))")){
                try(FileWriter writer = new FileWriter("valid.txt", true))
                {
                    writer.write("The database contains an incorrect product value: " + cart.toString());
                    writer.append('\n');
                    writer.flush();
                    cartList.add(cart);
                }
                catch(IOException ex){
                    System.out.println(ex.getMessage());
                }
            }
        }

        for (Cart cart: cartList){
            cartList.remove(cart);
            cartService.deleteItemsFromCart(cart.getId());
        }

        model.addAttribute("cartItems",cartItems);
        return "view_user_cart";
    }

    @GetMapping("/check")
    public String printCheck(Principal principal, Model model) throws Exception {
        CartItemsDto cartItemsDto = cartService.getCartItems(principal.getName());
        if(cartItemsDto.getItems().size() != 0){
            model.addAttribute("cartItems", cartItemsDto);
            return "view_check";
        }else {
            throw new Exception("Cart is Empty");
        }
    }

    @GetMapping("end_shopping")
    public String endShopping(Principal principal){
        CartItemsDto cartItemsDto = cartService.getCartItems(principal.getName());
        for (Cart items : cartItemsDto.getItems()){
            cartService.deleteItemsFromCart(items.getId());
        }
        return "redirect:/products";
    }
}
