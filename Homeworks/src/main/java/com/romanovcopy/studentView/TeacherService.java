package com.romanovcopy.studentView;

import com.romanovcopy.userComparator.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherService implements UserService<Teacher>{

    List<Teacher>teachers;

    public TeacherService() {
        teachers=new ArrayList<>();
    }

    @Override
    public List<Teacher> getAll() {
        return teachers;
    }

    @Override
    public void create(String name, int score, int age) {
        teachers.add(new Teacher(name, age));
    }

    @Override
    public void create(Teacher teacher) {
        teachers.add(teacher);
    }
}
