package dao.interfaces;

import entities.User;

import java.util.List;

/**
 * Created by User on 05.07.2017.
 */
public interface UserDao extends Dao<User,Integer> {
    List<User> findByUserRole(String role);
    List<User> findByUserEmailAndPassword(String email , String password);
}
