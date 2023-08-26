package com.romanovcopy.store;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StoreItem {

    private String name;
    private BigDecimal price;
    private double rating;
    private String id;

    public StoreItem( String name, BigDecimal price ){
        id = generationId();
        setName(name);
        setPrice(price);
    }

    public String getId() {
        return id;
    }
    public void setName(String name){
        if(!isNullOrEmpty(name)){
            this.name=name;
        }else {
            throw new IllegalArgumentException("Ошибка ввода. Повторите.");
        }
    }
    public String getName() {
        return name;
    }

    public void setPrice(BigDecimal price){
        if(price.compareTo(BigDecimal.ZERO)>0){
            this.price=price;
        }else {
            throw new IllegalArgumentException("Ошибка ввода. Повторите.");
        }
    }
    public BigDecimal getPrice() {
        return price;
    }

    public void setRating(double rating){
        this.rating=rating;
    }
    public double getRating() {
        return rating;
    }

    private boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private String generationId(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String formattedDate = dateFormat.format(new Date());
        return formattedDate.replaceAll("\\s+", "");
    }


    @Override
    public String toString() {
        return "StoreItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", rating=" + rating + '}';
    }
}
