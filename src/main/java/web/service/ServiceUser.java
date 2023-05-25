package web.service;

import web.models.User;

import java.util.List;

public interface ServiceUser {

    List<User> moreListServ ();

    User inIdServ(int id);
    void updateUserServ(int id, User updatedUser);

    void deleteUserServ (int id);

    void saveUserServ (User user);





}
