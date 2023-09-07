package com.romanovcopy.studentView;

import com.romanovcopy.userComparator.Teacher;

import java.util.List;

public class TeacherView <T extends Teacher> implements UserView<T>{
    @Override
    public void sendOnConsole(List<T> users) {
        for(T teacher:users){
            System.out.println(teacher);
        }
    }
}
