package org.skypro.skyshop.product;

public class Article implements Searchable {
    private final String title;
    private final String text;

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    @Override
    public String getSearchTerm() {
        return title + " " + text; // Возвращаем название и текст статьи как термин поиска
    }

    @Override
    public String getContentType() {
        return "ARTICLE"; // Тип контента
    }

    @Override
    public String getName() {
        return title; // Имя Searchable объекта
    }

    @Override
    public String toString() {
        return title + " " + text;
    }
}
