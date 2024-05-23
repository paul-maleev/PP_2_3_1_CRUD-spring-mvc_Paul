package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(int id, User updatedUser) {
        User userToBeUpdated = entityManager.find(User.class, updatedUser.getId());
        if (userToBeUpdated != null) {
            userToBeUpdated.setFirstName(updatedUser.getFirstName());
            userToBeUpdated.setLastName(updatedUser.getLastName());
            userToBeUpdated.setAge(updatedUser.getAge());
            userToBeUpdated.setEmail(updatedUser.getEmail());
            //entityManager.merge(userToBeUpdated);
        }
    }

    @Override
    public void delete(int id) {
        User userToDelete = entityManager.find(User.class, id);
        if (userToDelete != null) {
            entityManager.remove(userToDelete);
        }
    }
}
