package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.Product;

public class APP {
    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();

        Product apple = new SimpleProduct("Яблоко", 100);
        Product banana = new DiscountedProduct("Банан", 50, 10); // 10% скидка
        Product orange = new FixPriceProduct("Апельсин");
        Product pear = new SimpleProduct("Груша", 80);
        Product qiwi = new SimpleProduct("Киви", 90);

        basket.addProduct(apple);
        basket.addProduct(banana);
        basket.addProduct(orange);
        basket.addProduct(pear);
        basket.addProduct(qiwi);

        //попытка добавить продукт
        SimpleProduct mandarin = new SimpleProduct("Мандарин", 60);
        basket.addProduct(mandarin);
        //печать содержимого корзины
        basket.printBasket();
        //сумма корзины тотал
        System.out.println("Общая стоимость корзины " + basket.getTotalPrice());
        //поиск товара
        System.out.println("Содержит ли корзина Яблоко?" + basket.containsProduct("Яблоко"));
        //очистка корзины
        basket.clearBasket();
        //содержимое пустой корзины
        basket.printBasket();
        //стоимость пустой корзины
        System.out.println("Общая стоимость пустой корзины " + basket.getTotalPrice());
        //поиск товара в пустой корзине

        System.out.println("Содержит ли корзина Яблоко? " + basket.containsProduct("Яблоко"));
    }
}

