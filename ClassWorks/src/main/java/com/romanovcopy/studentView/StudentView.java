package com.romanovcopy.studentView;

import java.util.List;
import java.util.logging.Logger;

import com.romanovcopy.*
import com.romanovcopy.userComparator.User;

public class StudentView<T extends User> implements UserView{

    @Override
    public void sendOnConsole(List<T> students) {
        for(T user: students){
            logger.info(user.toString());
        }
    }
}
