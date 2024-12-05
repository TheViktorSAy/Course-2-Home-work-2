package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;



public class APP {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        Product apple = null;
        Product pear = null;
        Product qiwi = null;
        Product banana = null;
        Product orange = null;

        try {
            apple = new SimpleProduct("Яблоко", 100);
            pear = new SimpleProduct("Груша", 80);
            qiwi = new SimpleProduct("Киви", 90);
            banana = new DiscountedProduct("Банан", 50, 20); // процент скидки больше цены
            orange = new FixPriceProduct("Апельсин");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // добавление продуктов в корзину
        basket.addProduct(apple);
        basket.addProduct(banana);
        basket.addProduct(orange);
        basket.addProduct(pear);
        basket.addProduct(qiwi);

        // создание поисковика
        SearchEngine searchEngine = new SearchEngine(10);
        searchEngine.add(apple);
        searchEngine.add(banana);
        searchEngine.add(orange);
        searchEngine.add(pear);
        searchEngine.add(qiwi);

        // добавление статей
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



        // демонстрация поиска совпадений
        try {
            Searchable bestMatch = searchEngine.findBestMatch("яблоко");
            System.out.println("Лучший результат для 'яблоко': " + bestMatch);
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Searchable bestMatch = searchEngine.findBestMatch("неизвестный товар");
            System.out.println("Лучший результат для 'неизвестный товар': " + bestMatch);
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}





