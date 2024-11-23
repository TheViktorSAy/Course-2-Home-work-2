package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private Product[] products = new Product[5];
    private int productCount = 0;

    public void addProduct(Product product) {
        if (productCount < products.length) {
            products[productCount] = product;
            productCount++;
        } else {
            System.out.println("Невозможо добавить продукт");
        }
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (int i = 0; i < productCount; i++) {
            totalPrice += products[i].getPrice();
        }
        return totalPrice;
    }

    public void printContens() {
        if (productCount == 0) {
            System.out.println("В корзине пусто");
            return;
        }
        for (int i = 0; i < productCount; i++) {
            System.out.println(products[i].getName() + ": " + products[i].getPrice());
        }
        //System.out.println("Итого" + getTotalPrice());
    }

    public boolean containtsProduct(String name) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < productCount; i++) {
            products[i] = null;
        }
        productCount = 0;

    }


}


