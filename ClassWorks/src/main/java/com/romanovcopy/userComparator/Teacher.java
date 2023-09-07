package org.example;

public class Teacher extends User{
     private String objectToTeach;

    public String getObjectToTeach() {
        return objectToTeach;
    }

    public void setObjectToTeach(String objectToTeach) {
        this.objectToTeach = objectToTeach;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "objectToTeach='" + objectToTeach + '\'' +
                '}';
    }

    public Teacher(String name, String objectToTeach) {
        super(name);
        this.objectToTeach = objectToTeach;
    }

    public Teacher(String name) {
        super(name);
    }
}
