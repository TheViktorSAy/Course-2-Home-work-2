package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basePrice; // Базовая цена
    private final int discount;   // Скидка в процентах

    public DiscountedProduct(String name, int basePrice, int discount) {
        super(name);
        this.basePrice = basePrice;
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return basePrice - (basePrice * discount / 100); // Рассчитываем цену с учетом скидки
    }

    @Override
    public boolean isSpecial() {
        return true; // Это специальный товар
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (" + discount + "%)";
    }
}
