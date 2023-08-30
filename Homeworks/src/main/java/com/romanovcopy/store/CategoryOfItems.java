package com.romanovcopy.store;


import java.util.ArrayList;
import java.util.HashMap;

public class CategoryOfItems {


    private String categoryName;
    private HashMap<String, ArrayList<StoreItem>> listOfItems;

    public String getCategoryName() {
        return categoryName;
    }

    public CategoryOfItems(String name) {
        categoryName=name;
        listOfItems=new HashMap<>();
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * добавление товара
     * @param item товар
     * @param numbers количество
     * @return  True - успешно, False - ошибка
     */
    public boolean addItem(StoreItem item){
        if(item!=null){
            item.setAvailable(true);
            if(listOfItems.keySet().contains(item.getName())&&
            !listOfItems.get(item.getName()).contains(item)){
                listOfItems.get(item.getName()).add(item);
            }else if(!listOfItems.keySet().contains(item.getName())) {
                listOfItems.put(item.getName(),new ArrayList<>());
                listOfItems.get(item.getName()).add(item);
            }
            return true;
        }
        return false;
    }

    /**
     * удаление товара
     * @param item товар
     * @return  True - успешно, False - ошибка
     */
    public void removeItem(StoreItem item) {
        if (listOfItems.containsKey(item.getName())) {
            listOfItems.get(item.getName()).remove(item);
        }
    }

    /**
     * поиск товара по имени или части имени
     *
     * @param name имя или его часть
     * @return количество данного товара
     */
    public int search(String name) {
        StoreItem storeItem = null;
        int count=0;
        for (String itemName : listOfItems.keySet()) {
            if (itemName.toLowerCase().contains(name.toLowerCase())) {
                for(StoreItem item:listOfItems.get(itemName)){
                    if(item.isAvailable()){
                        count++;
                        System.out.println(item.getName());
                    }
                }
                return count;
            }
        }
        return -1;
    }

    /**
     * получение товара по точному наименованию
     * @param model точное наименование
     * @return искомый товар
     */
    public StoreItem getItem(String model){
        for(StoreItem item : listOfItems.get(model)){
            if(item.isAvailable())
                return item;
        }
        return null;
    }


    @Override
    public String toString() {
        return "CategoryOfItems{" +
                "categoryName='" + categoryName + '\'' +
                ", listOfItems=" + listOfItems +
                '}';
    }
}
