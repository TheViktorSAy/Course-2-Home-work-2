package org.skypro.skyshop.product;


public abstract class Product implements Searchable {
    private final String name;


    public Product(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial(); // Новый метод

    @Override
    public String getSearchTerm() {
        return getName(); // Возвращаем имя товара как термин поиска
    }

    @Override
    public String getContentType() {
        return "PRODUCT"; // Тип контента
    }

}


