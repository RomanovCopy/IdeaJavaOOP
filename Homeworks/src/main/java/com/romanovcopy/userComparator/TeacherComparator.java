package com.romanovcopy.userComparator;

import java.util.Comparator;

public class TeacherComparator <T extends User> implements Comparator<T>{

    @Override
    public int compare(T o1, T o2) {
        if(o1 instanceof Teacher && o2 instanceof Teacher){
            return o1.getAge()-o2.getAge();
        }
        return 0;
    }
}
