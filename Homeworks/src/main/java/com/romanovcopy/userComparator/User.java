package com.romanovcopy.userComparator;

public class User {

    private String name;
    private int score;
    private int age;

    public User(String name) {
        this.name = name;
    }


    public int getAge() {
        return this.age;
    }

    public void setAge(final int age) {
        this.age = age;
    }





    public int getScore(){
        if(this instanceof Student) {
            return getScore();
        } else {
            return 0;
        }
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", score=" + score + ", age=" + age + '}';
    }
}
