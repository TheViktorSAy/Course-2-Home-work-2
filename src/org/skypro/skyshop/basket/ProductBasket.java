package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> products = new HashMap<>();

    public void addProduct(Product product) {
        products.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    public int getTotalPrice() {
        int total = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
        } else {
            int specialCount = 0;
            for (List<Product> productList : products.values()) {
                for (Product product : productList) {
                    System.out.println(product.toString());
                    if (product.isSpecial()) {
                        specialCount++;
                    }
                }
            }
            System.out.println("Итого: " + getTotalPrice());
            System.out.println("Специальных товаров: " + specialCount);
        }
    }

    public List<Product> removeProductByName(String productName) {
        List<Product> removedProducts = new ArrayList<>();
        List<Product> productList = products.get(productName);

        if (productList != null) {
            removedProducts.addAll(productList);
            productList.clear();
            if (productList.isEmpty()) {
                products.remove(productName);
            }
        }

        return removedProducts;
    }

    public void clearBasket() {
        products.clear();
    }
}
