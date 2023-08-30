package com.romanovcopy;

import com.romanovcopy.store.CategoryOfItems;
import com.romanovcopy.store.StoreItem;
import com.romanovcopy.store.User;

import java.math.BigDecimal;
import java.net.SocketOption;
import java.util.HashMap;

public class Main {

    public static HashMap<String, CategoryOfItems>category;

    public static void main(String[] args) {

        category=new HashMap<>();

        /*
          создание категорий и заполнение их товаром
         */

        CategoryOfItems smartphones=new CategoryOfItems("Smartphones");
        smartphones.addItem(new StoreItem("Apple iPhone 12 Pro", new BigDecimal(900)),5);
        smartphones.addItem(new StoreItem("Samsung Galaxy S21 Ultra", new BigDecimal(600)),10);
        smartphones.addItem(new StoreItem("Xiaomi Mi 11", new BigDecimal(400)),15);
        smartphones.addItem(new StoreItem("Huawei P40 Pro", new BigDecimal(450)),7);

        CategoryOfItems laptops=new CategoryOfItems("Laptops");
        laptops.addItem(new StoreItem("Dell XPS 13", new BigDecimal(1900)),5);
        laptops.addItem(new StoreItem("HP Spectre x360", new BigDecimal(1500)),10);
        laptops.addItem(new StoreItem("Lenovo ThinkPad X1 Carbon", new BigDecimal(1400)),15);
        laptops.addItem(new StoreItem("Asus ZenBook Pro Duo", new BigDecimal(1450)),7);

        category.put(smartphones.getCategoryName(),smartphones);
        category.put(laptops.getCategoryName(),laptops);

        /*
         * создание пользователей/покупателей
         */

        User Alex=new User("Alex","12345", new BigDecimal(10000));
        User Anna=new User("Anna", "23456", new BigDecimal(10000));
        User Max=new User("Max", "23456", new BigDecimal(10000));

        /*
        все товары магазина
         */
        System.out.println(smartphones.toString());
        System.out.println(laptops.toString());

        /*
         * реализация покупок
         */
        StoreItem apple=smartphones.search("apple");
        if(apple!=null){
            System.out.println("Найден :"+ apple.toString());
            Alex.addStoreItem(smartphones, apple);
            Alex.getBasket().checkout();
        }


    }
}