package com.romanovcopy.store;

import com.romanovcopy.Main;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;

public class Basket {

    /**
     * Содержит товар и его количество
     */
    private ArrayList<StoreItem> items;
    private User user;

    public Basket(User user) {
        if(user!=null){
            this.user=user;
            items = new ArrayList<>();
        }
    }

    /**
     * Добавление товара выбранного наименования
     * @param item добавляемый товар
     */
    public void addItem(StoreItem item) {
        if(item.isAvailable()){
            items.add(item);
            item.setAvailable(false);
        }
    }

    /**
     * удаление одной единицы выбранного наименования
     * @param item выбранное наименование
     */
    public void removeItem(StoreItem item) {
        if (items.contains(item)) {
            items.remove(item);
            item.setAvailable(true);
        } else {
            System.out.println("Товар не найден в корзине.");
        }
    }

    /**
     * расчет общей стоимости товара в корзине
     * @return общая стоимость товара в корзине
     */
    private BigDecimal calculateTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (StoreItem item : items) {
            total = total.add(item.getPrice());
        }
        return total;
    }

    /**
     * завершение покупки с очисткой корзины
     */
    public boolean checkout() {
        BigDecimal total = calculateTotal();
        System.out.println("Всего: $" + total);
        if(user.topUpYourPersonalAccount(total.negate())){
            System.out.println("Платеж выполнен успешно!");
            for(CategoryOfItems category: Main.category.values()){
                for (StoreItem item : items) {
                    if(category.containsItem(item)){
                        category.removeItem(item);
                    }
                }
            }
            items.clear();
            return true;
        }
        System.out.println("Ошибка при проведении платежа");
        return false;
    }


    @Override
    public String toString() {
        return "Basket{" + "items=" + items + '}';
    }
}
