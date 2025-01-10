package org.skypro.skyshop;

import org.skypro.skyshop.product.Searchable;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;


public class SearchEngine {
    private Set<Searchable> searchableItems = new HashSet<>();

    public void add(Searchable item) {
        searchableItems.add(item);
    }

    public Set<Searchable> search(String term) {
        Supplier<TreeSet<Searchable>> treeSetSupplier = () -> new TreeSet<>(new SearchableComparator());

        return searchableItems.stream()
                .filter(item -> item.getSearchTerm().toLowerCase().contains(term.toLowerCase()))
                .collect(Collectors.toCollection(treeSetSupplier));
    }

    public class SearchableComparator implements Comparator<Searchable> {
        @Override
        public int compare(Searchable o1, Searchable o2) {
            int lengthComparison = Integer.compare(o2.getName().length(), o1.getName().length()); // Сравнение по длине
            if (lengthComparison != 0) {
                return lengthComparison; // Если длины разные, возвращаем результат сравнения по длине
            }
            return o1.getName().compareTo(o2.getName()); // Если длины одинаковые, сравниваем по имени
        }
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
