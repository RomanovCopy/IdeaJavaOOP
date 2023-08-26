package com.romanovcopy.store;

import java.util.ArrayList;

public class categoryOfItems {

    private String categoryName;
    private ArrayList<StoreItem> listOfItems;

    
    public categoryOfItems(String name, StoreItem[] items) {
        categoryName=name;
        listOfItems=new ArrayList<>();
        for(var item:items){
            listOfItems.add(item);
        }
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Boolean addItem(StoreItem item){
        if(listOfItems==null){
            listOfItems=new ArrayList<>();
        }
        return true;
    }


}
