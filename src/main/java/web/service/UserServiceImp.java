package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserDAO userDao;

    public UserServiceImp(UserDAO userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userDao.save(user);
    }

    @Override
    public User getUser(int id) {
        return userDao.show(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.update(user.getId(), user);
    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        userDao.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }
}
