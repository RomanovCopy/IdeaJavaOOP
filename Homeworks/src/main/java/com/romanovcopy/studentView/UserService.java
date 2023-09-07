package com.romanovcopy.studentView;

import java.util.List;

public interface UserService<T> {
    List<T> getAll();
    void create(String name,int score,int age);
    void create(T t);
}
