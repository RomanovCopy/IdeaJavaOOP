package com.romanovcopy.userComparator;

public class Teacher extends User{


    private String name;
    private String objectToTeach;

    public Teacher(String name, int age) {
        super(name);
        setAge(age);
    }

    public String getObjectToTeach() {
        return objectToTeach;
    }


    public Teacher(String name) {
        super(name);
    }

    public void setObjectToTeach(String objectToTeach) {
        this.objectToTeach = objectToTeach;
    }
}
