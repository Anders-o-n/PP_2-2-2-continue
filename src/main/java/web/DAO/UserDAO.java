package web.DAO;

import web.models.User;

import java.util.List;

public interface UserDAO {

    List<User> moreList();

    User inId(int id);
    void updateUser (int id, User user);

    void deleteUser(int id);

    void saveUser(User user);


}
