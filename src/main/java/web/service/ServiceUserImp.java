package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.DAO.UserDAO;
import web.models.User;


import java.util.List;


@Service
@Transactional(readOnly = true)
public class ServiceUserImp implements ServiceUser{

    private final UserDAO userDAO;

    @Autowired
    public ServiceUserImp(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> moreListServ () {
        return userDAO.moreList();
    }

    @Override
    public User inIdServ(int id) {
        return userDAO.inId(id);
    }

    @Override
    @Transactional
    public void updateUserServ (int id, User updatedUser) {
        userDAO.updateUser(id, updatedUser);
    }

    @Override
    @Transactional
    public void deleteUserServ (int id) {
        userDAO.deleteUser(id);
    }
    @Override
    @Transactional
    public void saveUserServ (User user) {
        userDAO.saveUser(user);
    }



}
