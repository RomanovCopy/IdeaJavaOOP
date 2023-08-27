package com.romanovcopy.store;

import java.util.ArrayList;
import java.util.HashMap;

public class categoryOfItems {

    private String categoryName;
    private HashMap<StoreItem, Integer> listOfItems;


    public categoryOfItems(String name, StoreItem[] items) {
        categoryName=name;
        listOfItems=new HashMap<>();
        for(int i=0; i< items.length;i++){
            if(listOfItems.containsKey(items[i])){
                System.out.println(items[i].toString()+" - уже существует");
            }
            else {

            }
        }
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public boolean addItem(StoreItem item){
        if(item!=null){
            if(listOfItems==null){
                listOfItems=new HashMap<>();
            }
            listOfItems.put(item, listOfItems.getOrDefault(item, 0) + 1);
        }else return false;

        return true;
    }

    public boolean removeItem(StoreItem item){
        if(listOfItems.containsKey(item)){
            listOfItems.remove(item);
            return true;
        }
        return false;
    }



}
