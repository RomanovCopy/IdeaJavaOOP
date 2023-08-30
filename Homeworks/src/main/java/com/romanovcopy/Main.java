package com.romanovcopy;

import com.romanovcopy.store.CategoryOfItems;
import com.romanovcopy.store.StoreItem;
import com.romanovcopy.store.User;

import java.math.BigDecimal;
import java.net.SocketOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static ArrayList<CategoryOfItems>category;
    public static HashMap<LocalDateTime, StoreItem>storeSales;


    public static void main(String[] args) {

        category= new ArrayList<>();
        storeSales=new HashMap<>();

        /*
          создание категорий и заполнение их товаром
         */

        CategoryOfItems smartphones=new CategoryOfItems("Smartphones");
        smartphones.addItem(new StoreItem("Apple iPhone 12 Pro", new BigDecimal(900)));
        smartphones.addItem(new StoreItem("Samsung Galaxy S21 Ultra", new BigDecimal(600)));
        smartphones.addItem(new StoreItem("Xiaomi Mi 11", new BigDecimal(400)));
        smartphones.addItem(new StoreItem("Huawei P40 Pro", new BigDecimal(450)));

        CategoryOfItems laptops=new CategoryOfItems("Laptops");
        laptops.addItem(new StoreItem("Dell XPS 13", new BigDecimal(1900)));
        laptops.addItem(new StoreItem("HP Spectre x360", new BigDecimal(1500)));
        laptops.addItem(new StoreItem("Lenovo ThinkPad X1 Carbon", new BigDecimal(1400)));
        laptops.addItem(new StoreItem("Asus ZenBook Pro Duo", new BigDecimal(1450)));

        category.add(smartphones);
        category.add(laptops);

        /*
         * создание пользователей/покупателей
         */

        User Alex=new User("Alex","12345", new BigDecimal(10000));
        User Anna=new User("Anna", "23456", new BigDecimal(10000));
        User Max=new User("Max", "23456", new BigDecimal(100));

        /*
        все товары магазина
         */
        System.out.println(smartphones.toString());
        System.out.println(laptops.toString());

        /*
         * реализация покупок
         */
        if(smartphones.search("apple")>0){
            StoreItem apple=smartphones.getItem("Apple iPhone 12 Pro");
            System.out.println("Приобретается :"+ apple.toString());
            sale(Alex, smartphones, apple);
        }

        if(laptops.search("dell")>0){
            StoreItem dell=laptops.getItem("Dell XPS 13");
            System.out.println("Приобретается :"+ dell.toString());
            sale(Anna, laptops, dell);
        }

        if(smartphones.search("huawei")>0){
            StoreItem huawei=smartphones.getItem("Huawei P40 Pro");
            System.out.println("Приобретается :"+ huawei.toString());
            sale(Max, smartphones, huawei);
        }

        /*
        Вывод всех покупок
         */
        allSales();
    }

    /**
     * реализация покупки
     * @param user  покупатель
     * @param category  категория товара
     * @param storeItem  товар
     */
    private static void sale(User user, CategoryOfItems category ,StoreItem storeItem){
        System.out.println("Личный счет до покупки: "+user.getPersonalAccount());
        user.addStoreItem(category,storeItem);
        if(user.getBasket().checkout()){
            storeSales.put(LocalDateTime.now(),storeItem);
            category.removeItem(storeItem);
            System.out.println("Удачная покупка : "+user.getPersonalAccount());
        }else {
            System.out.println("Покупка не состоялась : "+user.getPersonalAccount());
        }
    }

    /**
     * вывод всех покупок
     */
    private static void allSales(){
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        for(LocalDateTime date:storeSales.keySet()){
            System.out.println(date.format(formatter)+"  "+storeSales.get(date).toString()+"\n");
        }
    }
}