package web.dao;

import web.model.User;

import java.util.List;

public interface  UserDAO {
    List<User> listUsers();
    User show(int id);
    void save(User user);
    void update(int id, User updatedUser);
    void delete(int id);
}
