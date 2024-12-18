package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;


import java.util.List;

public class APP {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();

        Product apple = new SimpleProduct("Яблоко", 100);
        Product pear = new SimpleProduct("Груша", 80);
        Product qiwi = new SimpleProduct("Киви", 90);
        Product banana = new DiscountedProduct("Банан", 50, 20);
        Product orange = new FixPriceProduct("Апельсин");

        // добавление продуктов в корзину
        basket.addProduct(apple);
        basket.addProduct(banana);
        basket.addProduct(orange);
        basket.addProduct(pear);
        basket.addProduct(qiwi);

        // создание поисковика
        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(apple);
        searchEngine.add(banana);
        searchEngine.add(orange);
        searchEngine.add(pear);
        searchEngine.add(qiwi);

        // демонстрация удаления продукта
        List<Product> removedProducts = basket.removeProductByName("Груша" +
                "");
        System.out.println("Удаленные продукты: " + removedProducts);
        basket.printBasket();

        // попытка удалить несуществующий продукт
        List<Product> removedProductsNonExistent = basket.removeProductByName("Неизвестный продукт");
        if (removedProductsNonExistent.isEmpty()) {
            System.out.println("Список пуст");
        }
        basket.printBasket();

        // демонстрация поиска всех совпадений
        List<Searchable> searchResults = searchEngine.search("банан");
        System.out.println("Результаты поиска для 'банан': " + searchResults);
    }
}





