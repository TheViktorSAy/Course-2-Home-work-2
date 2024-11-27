package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.Article;

import java.util.Arrays;

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
        //SimpleProduct mandarin = new SimpleProduct("Мандарин", 60);
        //basket.addProduct(mandarin);
        //печать содержимого корзины
        //basket.printBasket();
        //сумма корзины тотал
        //System.out.println("Общая стоимость корзины " + basket.getTotalPrice());
        //поиск товара
        //System.out.println("Содержит ли корзина Яблоко?" + basket.containsProduct("Яблоко"));
        //очистка корзины
        //basket.clearBasket();
        //содержимое пустой корзины
        //basket.printBasket();
        //стоимость пустой корзины
        //System.out.println("Общая стоимость пустой корзины " + basket.getTotalPrice());
        //поиск товара в пустой корзине
        //System.out.println("Содержит ли корзина Яблоко? " + basket.containsProduct("Яблоко"));

        // Создание объекта SearchEngine
        SearchEngine searchEngine = new SearchEngine(10);
        searchEngine.add(apple);
        searchEngine.add(banana);
        searchEngine.add(orange);
        searchEngine.add(pear);
        searchEngine.add(qiwi);

        // Создание и добавление статей
        Article article1 = new Article("Свойство яблоко - ", "Яблоки полезны для дёсен.");
        Article article2 = new Article("Секреты банан - ", "Бананы содержат много калия.");
        Article article3 = new Article("Польза апельсин - ", "Апельсины полезны для здоровья.");
        Article article4 = new Article("Уникальность груша - ", "Груши красивые");
        Article article5 = new Article("Преимущество киви - ", "Киви мохнатые.");


        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        searchEngine.add(article4);
        searchEngine.add(article5);


        // Демонстрация функциональности поиска
        System.out.println("Результаты поиска для 'Яблоко': " + Arrays.toString(searchEngine.search("Яблоко")));
        System.out.println("Результаты поиска для 'Банан': " + Arrays.toString(searchEngine.search("Банан")));
        System.out.println("Результаты поиска для 'Апельсин': " + Arrays.toString(searchEngine.search("Апельсин")));
        System.out.println("Результаты поиска для 'Груша': " + Arrays.toString(searchEngine.search("Груша")));
        System.out.println("Результаты поиска для 'Киви': " + Arrays.toString(searchEngine.search("Киви")));


    }


}



