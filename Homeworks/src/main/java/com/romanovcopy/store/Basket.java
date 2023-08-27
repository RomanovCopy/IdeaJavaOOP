package com.romanovcopy.store;


import java.util.HashMap;
import java.util.Map;


public class Basket {

    /**
     * Содержит товар и его количество
     */
    private Map<StoreItem, Integer> items;

    public Basket() {
        items = new HashMap<>();
    }

    /**
     * Добавление товара
     * @param item добавляемый товар
     */
    public void addItem(StoreItem item) {
        items.put(item, items.getOrDefault(item, 0) + 1);
    }

    /**
     * удаление товара
     * @param item удаляемый товар
     */
    public void removeItem(StoreItem item) {
        if (items.containsKey(item)) {
            int quantity = items.get(item);
            if (quantity > 1) {
                items.put(item, quantity - 1);
            } else {
                items.remove(item);
            }
        } else {
            System.out.println("Товар не найден в корзине.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Товары в корзине:\n");
        for (Map.Entry<StoreItem, Integer> entry : items.entrySet()) {
            StoreItem item = entry.getKey();
            int quantity = entry.getValue();
            sb.append(item.getName()).append(" - ").append(item.getPrice()).append(" (Количество: ").append(quantity).append(")\n");
        }
        return sb.toString();
    }

}
