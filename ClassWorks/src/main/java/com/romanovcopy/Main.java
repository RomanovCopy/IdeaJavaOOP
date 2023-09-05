package com.romanovcopy;

import com.romanovcopy.userComparator.Student;
import com.romanovcopy.userComparator.UserComparator;
import com.romanovcopy.userComparator.Teacher;
import com.romanovcopy.userComparator.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student s1=new Student("Sergey", "Romanov");
        Student s2=new Student("Ekaterina","Milohina");
        Teacher t1=new Teacher("Varlamova", "Nata");
        List<User>list=new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(t1);
        list.sort(new UserComparator());
        System.out.println(list);
    }
}