package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    void save(User user);

    User showUser(long id);

    void editUser(User user);

    void deleteUser(long id);
}
