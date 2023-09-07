package com.romanovcopy;

import com.romanovcopy.userComparator.*;
import com.romanovcopy.studentView.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        teacherComparator();
        teacherService();
        teacherView();
    }

    private static void teacherComparator(){
        Teacher teacher1=new Teacher("Teacher1");
        teacher1.setAge(25);
        Teacher teacher2=new Teacher("Teacher2");
        teacher2.setAge(24);
        Teacher teacher3=new Teacher("Teacher3");
        teacher3.setAge(58);
        Teacher teacher4=new Teacher("Teacher4");
        teacher4.setAge(50);
        List<Teacher>list=new ArrayList<>();
        list.add(teacher1);
        list.add(teacher2);
        list.add(teacher3);
        list.add(teacher4);
        list.sort(new TeacherComparator<Teacher>());
        System.out.println(list);
    }

    private static void teacherService(){
        Teacher teacher1=new Teacher("Teacher1");
        teacher1.setAge(25);
        Teacher teacher2=new Teacher("Teacher2");
        teacher2.setAge(24);
        Teacher teacher3=new Teacher("Teacher3");
        teacher3.setAge(58);
        Teacher teacher4=new Teacher("Teacher4");
        teacher4.setAge(50);
        TeacherService teacherService=new TeacherService();
        teacherService.create(teacher1 );
        teacherService.create(teacher2);
        teacherService.create(teacher3);
        teacherService.create(teacher4);
        System.out.println(teacherService.getAll());
    }

    private static void teacherView(){
        Teacher teacher1=new Teacher("Teacher1");
        teacher1.setAge(25);
        Teacher teacher2=new Teacher("Teacher2");
        teacher2.setAge(24);
        Teacher teacher3=new Teacher("Teacher3");
        teacher3.setAge(58);
        Teacher teacher4=new Teacher("Teacher4");
        teacher4.setAge(50);
        List<Teacher>list=new ArrayList<>();
        list.add(teacher1);
        list.add(teacher2);
        list.add(teacher3);
        list.add(teacher4);
        TeacherView teacherView=new TeacherView();
        teacherView.sendOnConsole(list);
    }


}