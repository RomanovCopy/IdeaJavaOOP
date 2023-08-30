package com.romanovcopy.store;


import java.util.HashMap;

public class CategoryOfItems {


    private String categoryName;
    private HashMap<StoreItem, Integer> listOfItems;

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
    public boolean addItem(StoreItem item, int numbers){
        if(item!=null){
            if(listOfItems==null){
                listOfItems=new HashMap<>();
            }
            listOfItems.put(item, listOfItems.getOrDefault(item, 0) + numbers);
            return true;
        }
        return false;
    }

    /**
     * удаление товара
     * @param item товар
     * @return  True - успешно, False - ошибка
     */
    public boolean removeItem(StoreItem item){
        int balanceOfGoods=0;
        if(listOfItems.containsKey(item)){
            balanceOfGoods=listOfItems.get(item);
            if(balanceOfGoods>=1){
                listOfItems.put(item, listOfItems.get(item) - 1);
            } else {
                System.out.println("Недостаточное количество товара.");
                return false;
            }
            if(listOfItems.get(item)<=0){
                listOfItems.remove(item);
            }
            return true;
        }
        return false;
    }

    /**
     * поиск товара по имени или части имени
     * @param name имя или его часть
     * @return ссылка на товар
     */
    public StoreItem search(String name){
        StoreItem storeItem =null;
        for(StoreItem item:listOfItems.keySet()){
            if(item.getName().toLowerCase().contains(name.toLowerCase())){
                return item;
            }
        }
        return null;
    }

    public boolean containsItem(StoreItem item){
        return listOfItems.containsKey(item);
    }


    @Override
    public String toString() {
        return "CategoryOfItems{" +
                "categoryName='" + categoryName + '\'' +
                ", listOfItems=" + listOfItems +
                '}';
    }
}
