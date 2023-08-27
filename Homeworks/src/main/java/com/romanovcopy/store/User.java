package com.romanovcopy.store;

public class User {
    private String login;
    private String password;
    private Basket basket;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.basket = new Basket();
    }

    /**
     * добавление товара в корзину
     * @param category категория товара
     * @param item товар
     * @param numbers количество
     */
    public void addStoreItem(CategoryOfItems category, StoreItem item, int numbers){
        if(basket==null){
            basket=new Basket();
        }
        if(category.containsItem(item)){
            if(category.removeItem(item, numbers)){
                basket.addItem(item);
            }
        }
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Basket getBasket() {
        return basket;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' + basket.toString()+
                '}';
    }

}