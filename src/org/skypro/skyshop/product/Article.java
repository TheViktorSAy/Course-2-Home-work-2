package org.skypro.skyshop.product;

import java.util.Objects;

public class Article implements Searchable {
    private final String title;
    private final String text;

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    @Override
    public String getSearchTerm() {
        return title + text; // Возвращаем название и текст статьи как термин поиска
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(title, article.title) && Objects.equals(text, article.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, text);
    }

    @Override
    public String toString() {
        return title + " " + text;
    }


}
