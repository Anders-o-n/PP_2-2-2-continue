package web.DAO;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class UserDAOImp implements UserDAO {

    private final EntityManager entityManager;

    @Autowired
    public UserDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> moreList() {
        try (Session session = entityManager.unwrap(Session.class)) {
            return session.createQuery("select u from User u", User.class).getResultList();
        }
    }

    @Override
    public User inId(int id) {
        try (Session session = entityManager.unwrap(Session.class)) {
            return session.get(User.class, id);
        }
    }
    @Override
    @Transactional
    public void updateUser (int id, User user) {
        try (Session session = entityManager.unwrap(Session.class)) {
            User curUser = session.get(User.class, id);
            curUser.setAge(user.getAge());
            curUser.setName(user.getName());
            curUser.setSurname(user.getSurname());
        }
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        try (Session session = entityManager.unwrap(Session.class)) {
            session.remove(session.get(User.class, id));
        }
    }
    @Override
    @Transactional
    public void saveUser(User user) {
        try (Session session = entityManager.unwrap(Session.class)) {
            session.persist(user);
        }
    }


}
