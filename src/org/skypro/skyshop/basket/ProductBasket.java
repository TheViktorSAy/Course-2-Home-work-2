package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;


public class ProductBasket {
    private Product[] products = new Product[5];
    private int count = 0;

    public void addProduct(Product product) {
        if (count < products.length) {
            products[count] = product;
            count++;
        } else {
            System.out.println("Невозможно добавить продукт");
        }
    }

    public int getTotalPrice() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += products[i].getPrice();
        }
        return total;
    }

    public void printBasket() {
        if (count == 0) {
            System.out.println("В корзине пусто");
        } else {
            int specialCount = 0;
            for (int i = 0; i < count; i++) {
                System.out.println(products[i].toString());
                if (products[i].isSpecial()) {
                    specialCount++;
                }
            }
            System.out.println("Итого: " + getTotalPrice());
            System.out.println("Специальных товаров: " + specialCount);
        }
    }


    public boolean containsProduct(String productName) {
        for (int i = 0; i < count; i++) {
            if (products[i].getName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
        count = 0;
    }
}
