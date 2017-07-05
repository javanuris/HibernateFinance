package dao;

import dao.interfaces.UserDao;
import entities.User;
import org.hibernate.Query;
import java.util.List;

/**
 * Created by User on 05.07.2017.
 */
public class UserHibernateDao extends AbstractDao<User, Integer> implements UserDao {
    public List<User> findByUserRole(String role){
        Query query = getSession().createQuery("select u from User u where u.role.name like :role").setParameter("role", role);
        return query.list();
    }

    public List<User> findByUserEmailAndPassword(String email , String password){
        Query query = getSession().createQuery("select u from User u where u.email like :email and u.password like :password").setParameter("email", email).setString("password" , password);
        return query.list();
    }

}
