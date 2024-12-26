package org.skypro.skyshop;
import org.skypro.skyshop.product.Searchable;
import java.util.*;


public class SearchEngine {
    private Set<Searchable> searchableItems = new HashSet<>();

    public void add(Searchable item) {
        searchableItems.add(item);
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

    public Set<Searchable> search(String term) {
        TreeSet<Searchable> results = new TreeSet<>(new SearchableComparator()); // Используем TreeMap для сортировки по ключу

        for (Searchable item : searchableItems) {
            if (item.getSearchTerm().toLowerCase().contains(term.toLowerCase())) {
                results.add(item);
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
