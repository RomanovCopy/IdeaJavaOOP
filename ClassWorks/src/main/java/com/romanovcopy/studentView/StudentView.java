package com.romanovcopy.studentView;

import java.util.List;
import java.util.logging.Logger;

import com.romanovcopy.userComparator.*;

public class StudentView<T extends User> implements UserView<T>{
    @Override
    public void sendOnConsole(List<T> users) {
        for(T user: users){
            user.toString();
        }
    }
}
