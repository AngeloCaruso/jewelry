package com.example.jewelryshop;

import java.util.ArrayList;

public class ShoppingCart {

    private static ArrayList<Jewel> cart = new ArrayList<>();

    public static void addToCart(Jewel order){
        cart.add(order);
    }
    public static ArrayList<Jewel> showOrders(){
        return cart;
    }
}
