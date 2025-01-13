package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

import java.util.List;
import java.util.Map;
import java.util.Set;


public class APP {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        Product apple = new SimpleProduct("Яблоко", 100);
        Product pear = new SimpleProduct("Груша", 80);
        Product qiwi = new SimpleProduct("Киви", 90);
        Product banana = new DiscountedProduct("Банан", 50, 20);
        Product orange = new FixPriceProduct("Апельсин");

        // создание поисковика
        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(apple);
        searchEngine.add(banana);
        searchEngine.add(orange);
        searchEngine.add(pear);
        searchEngine.add(qiwi);

        // Пример добавления статей
        // Создание и добавление статей
        Article article1 = new Article("Статья Свойство яблоко - ", "Яблоки полезны для дёсен.");
        Article article2 = new Article("Статья Секреты банан - ", "Бананы содержат много калия.");
        Article article3 = new Article("Статья Польза апельсин - ", "Апельсины полезны для здоровья.");
        Article article4 = new Article("Статья Уникальность груша - ", "Груши красивые.");
        Article article5 = new Article("Статья Преимущество киви - ", "Киви мохнатые.");


        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        searchEngine.add(article4);
        searchEngine.add(article5);


        // Поиск
        Set<Searchable> searchResults = searchEngine.search("статья");
        System.out.println("Результаты поиска: ");
        for (Searchable result : searchResults) {
            System.out.println(result);
        }

    }
}





