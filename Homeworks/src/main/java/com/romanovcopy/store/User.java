package com.romanovcopy.store;

import java.math.BigDecimal;

public class User {
    private String login;
    private String password;
    private Basket basket;
    private BigDecimal personalAccount;



    public User(String login, String password, BigDecimal personalAccount) {
        this.login = login;
        this.password = password;
        this.personalAccount=personalAccount;
        this.basket = new Basket();
    }


    /**
     * личный счет покупателя
     * @return сумма на личном счете
     */
    public BigDecimal getPersonalAccount() {
        return personalAccount;
    }

    /**
     * пополнение/снятие денежных средств
     * @param amount сумма пополнения/снятия
     */
    public void topUpYourPersonalAccount(BigDecimal amount){
        personalAccount = personalAccount.add(amount);
    }

    /**
     * добавление товара в корзину
     * @param category категория товара
     * @param item товар
     */
    public void addStoreItem(CategoryOfItems category, StoreItem item){
        if(basket==null){
            basket=new Basket();
        }
        if(category.containsItem(item) && personalAccount.compareTo(item.getPrice())>=0){
            if(category.removeItem(item)){
                personalAccount=personalAccount.subtract(item.getPrice());
                basket.addItem(item);
            }
            else {
                System.out.println("Товар недоступен к покупке.");
            }
        }else {
            System.out.println("На Вашем счете недостаточно средств.");
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