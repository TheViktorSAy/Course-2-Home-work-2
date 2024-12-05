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

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        int maxCount = 0;
        Searchable bestMatch = null;

        for (int i = 0; i < count; i++) {
            String term = searchableItems[i].getSearchTerm();
            int currentCount = countOccurrences(term.toLowerCase(), search.toLowerCase());

            if (currentCount > maxCount) {
                maxCount = currentCount;
                bestMatch = searchableItems[i];
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound("Не найдено подходящих результатов для запроса: " + search);
        }

        return bestMatch;
    }

    private int countOccurrences(@org.jetbrains.annotations.NotNull String str, String substring) {
        int count = 0;
        int index = 0;

        while ((index = str.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }
        return count;
    }
}
