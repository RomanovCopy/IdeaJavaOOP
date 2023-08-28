package com.romanovcopy.store;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StoreItem {

    private String name;
    private BigDecimal price;
    private double rating;
    private String id;
    private boolean isAvailable;




    public StoreItem( String name, BigDecimal price ){
        id = generationId();
        setName(name);
        setPrice(price);
        isAvailable=true;
    }

    /**
     * получение информации о доступности товара
     * @return true - доступен, false - недоступен
     */
    public boolean isAvailable() {
        return isAvailable;
    }

    /**
     * установка доступности товара
     * @param available true - доступен, false - недоступен
     */
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    /**
     * получение ID товара
     * @return ID товара
     */
    public String getId() {
        return id;
    }

    /**
     * наименования товара
     * @param name наименование товара
     */
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

    /**
     * стоимость товара
     * @param price
     */
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

    /**
     * рейтинг товара
     * @param rating
     */
    public void setRating(double rating){
        this.rating=rating;
    }
    public double getRating() {
        return rating;
    }

    /**
     * проверка строки
     * @param str
     * @return
     */
    private boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    /**
     * генерация уникального Id товара
     * @return
     */
    private String generationId(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String formattedDate = dateFormat.format(new Date());
        return formattedDate.replaceAll("\\s+", "");
    }

    /**
     * сравнение на идентичность
     * @param obj  товар для сравнения
     * @return результат
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StoreItem other = (StoreItem) obj;
        if(other!=null){
            return other.getPrice().equals(this.getPrice())&&other.getName().equals(this.getName());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StoreItem{" + "name='" + name +
                '\'' + ", price=" + price +
                ", rating=" + rating +
                ", id='" + id +
                '\'' + '}';
    }
}
