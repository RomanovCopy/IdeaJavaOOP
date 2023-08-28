package com.romanovcopy.store;

import lombok.ToString;
import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;

public class Basket {

    /**
     * Содержит товар и его количество
     */
    private Map<StoreItem, Integer> items;

    public Basket() {
        items = new HashMap<>();
    }

    /**
     * Добавление товара выбранного наименования
     * @param item добавляемый товар
     */
    public void addItem(StoreItem item) {
        if(item.isAvailable()){
            items.put(item, items.getOrDefault(item, 0) + 1);
            item.setAvailable(false);
        }
    }

    /**
     * удаление одной единицы выбранного наименования
     * @param item выбранное наименование
     */
    public void removeItem(StoreItem item) {
        if (items.containsKey(item)) {
            int quantity = items.get(item);
            if (quantity > 1) {
                items.put(item, quantity - 1);
            } else {
                items.remove(item);
            }
            item.setAvailable(true);
        } else {
            System.out.println("Товар не найден в корзине.");
        }
    }

    /**
     * расчет общей стоимости товара в корзине
     * @return общая стоимость товара в корзине
     */
    public BigDecimal calculateTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (StoreItem item : items.keySet()) {
            total = total.add(item.getPrice());
        }
        return total;
    }

    /**
     * завершение покупки с очисткой корзины
     */
    public void checkout() {
        BigDecimal total = calculateTotal();
        System.out.println("Total: $" + total);
        // Логика для обработки платежа и оформления заказа
        // Например, отправка запроса на платежный шлюз и генерация номера заказа
        System.out.println("Checkout completed!");
        for (StoreItem item : items.keySet()) {
            item.setAvailable(true);
        }
        items.clear();
    }


    @Override
    public String toString() {
        return "Basket{" + "items=" + items + '}';
    }
}
