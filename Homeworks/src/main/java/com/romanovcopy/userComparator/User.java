package org.example;

public class User {
    public int getScore(){
        if(this instanceof Student) {
            return getScore();
        } else {
            return 0;
        }
    }
    public User(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
