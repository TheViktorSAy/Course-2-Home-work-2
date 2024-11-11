package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class APP {
    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();
        Product product1 = new Product("Яблоко", 100);
        Product product2 = new Product("Банан", 50);
        Product product3 = new Product("Апельсин", 70);
        Product product4 = new Product("Груша", 80);
        Product product5 = new Product("Киви", 90);

        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);

        Product product6 = new Product("Мандарин", 60);
        basket.addProduct(product6);
        basket.printContens();
        System.out.println( "Общая стоимость корзины " + basket.getTotalPrice());
        System.out.println("Содержит ли корзина Яблоко?" + basket.containtsProduct("Груша"));
        basket.clearBasket();
        basket.printContens();
        System.out.println("Общая стоимость пустой корзины " + basket.getTotalPrice());
        System.out.println("Содержит ли корзина яблоко? " + basket.containtsProduct("Яблоко"));
    }
}

