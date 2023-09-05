package com.romanovcopy.studentView;

import com.romanovcopy.userComparator.*;

import java.util.List;

public interface UserView<T extends User> {

    public void sendOnConsole(List<T> users);

}
