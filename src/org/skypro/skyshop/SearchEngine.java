package org.skypro.skyshop;
import org.skypro.skyshop.product.Searchable;

public class SearchEngine {
    private Searchable[] searchableItems;
    private int count = 0;

    public SearchEngine(int size) {
        searchableItems = new Searchable[size];
    }

    public void add(Searchable item) {
        if (count < searchableItems.length) {
            searchableItems[count] = item;
            count++;
        } else {
            System.out.println("Невозможно добавить элемент в поисковый движок");
        }
    }

    public Searchable[] search(String term) {
        Searchable[] results = new Searchable[5];
        int resultCount = 0;

        for (int i = 0; i < count; i++) {
            if (searchableItems[i].getSearchTerm().toLowerCase().contains(term.toLowerCase())) {
                results[resultCount] = searchableItems[i];
                resultCount++;
                if (resultCount == 5) break; // Ограничиваем до 5 результатов
            }
        }

        return results;
    }
}
