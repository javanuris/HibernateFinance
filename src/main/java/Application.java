import dao.CategoryHibernateDao;
import dao.UserHibernateDao;
import dao.interfaces.CategoryDao;
import dao.interfaces.UserDao;
import entities.Role;
import entities.User;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.util.List;


public class Application {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        UserDao userDao = new UserHibernateDao();
        userDao.setSession(session);

        User user = new User();
        user.setFirstName("Marat");
        user.setLastName("Samatov");
        user.setEmail("marat@gmail");
        user.setPassword("123456");
        Role role = (Role) session.get(Role.class , 1);
        user.setRole(role);

        session.save(user);

        System.out.println();
        session.getTransaction().commit();
        session.close();
        HibernateUtil.getSessionFactory().close();
    }
}
