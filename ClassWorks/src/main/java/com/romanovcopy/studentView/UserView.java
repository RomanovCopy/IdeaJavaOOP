package Task2;

import org.example.User;

import java.util.List;

public interface UserView<T extends User> {
    public void sendOnConsole(List<T> users);
}
