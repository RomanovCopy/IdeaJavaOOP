package com.romanovcopy.studentView;

import com.romanovcopy.userComparator.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService implements UserService<Student> {
    private List<Student> students;

    public StudentService() {
        this.students = new ArrayList<>();
    }

    @Override
    public List<Student> getAll() {
        return students;
    }

    @Override
    public void create(String name, int score, int age) {
        Student student = new Student(name,score,age);
        students.add(student);
    }

    @Override
    public void create(Student student) {
        students.add(student);
    }

}
