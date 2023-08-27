package com.romanovcopy.store;

import java.util.HashMap;

public class CategoryOfItems {

    private String categoryName;
    private HashMap<StoreItem, Integer> listOfItems;


    public CategoryOfItems(String name) {
        categoryName=name;
        listOfItems=new HashMap<>();
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

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
     * удаление/покупка товара
     * @param item товар
     * @param numbers количество
     * @return  True - успешно, False - ошибка
     */
    public boolean removeItem(StoreItem item, int numbers){
        int balanceOfGoods=0;
        if(listOfItems.containsKey(item)){
            balanceOfGoods=listOfItems.get(item);
            if(balanceOfGoods>=numbers){
                listOfItems.put(item, listOfItems.get(item) - numbers);
            }
            else {
                System.out.println("Недостаточное количество товара.");
                return false;
            }
            if(listOfItems.get(item)==0){
                listOfItems.remove(item);
            }
            return true;
        }
        return false;
    }


    public boolean containsItem(StoreItem item){
        return listOfItems.containsKey(item);
    }


}
