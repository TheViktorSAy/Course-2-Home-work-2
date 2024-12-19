package org.skypro.skyshop;

import org.skypro.skyshop.product.Searchable;

import java.util.*;

public class SearchEngine {
    private List<Searchable> searchableItems = new ArrayList<>();

    public void add(Searchable item) {
        searchableItems.add(item);
    }

    public Map<String, Searchable> search(String term) {
        Map<String, Searchable> results = new TreeMap<>(); // Используем TreeMap для сортировки по ключу

        for (Searchable item : searchableItems) {
            if (item.getSearchTerm().toLowerCase().contains(term.toLowerCase())) {
                results.put(item.getName(), item);
            }
        }

        return results;
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        int maxCount = 0;
        Searchable bestMatch = null;

        for (Searchable item : searchableItems) {
            String term = item.getSearchTerm();
            int currentCount = countOccurrences(term.toLowerCase(), search.toLowerCase());

            if (currentCount > maxCount) {
                maxCount = currentCount;
                bestMatch = item;
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound("Не найдено подходящих результатов для запроса: " + search);
        }

        return bestMatch;
    }

    private int countOccurrences(String str, String substring) {
        int count = 0;
        int index = 0;

        while ((index = str.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }
        return count;
    }
}
