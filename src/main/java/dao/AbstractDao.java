package dao;

import dao.interfaces.Dao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import utils.HibernateUtil;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by User on 05.07.2017.
 */
public class AbstractDao<T, ID extends Serializable> implements Dao<T, ID> {
    private Class<T> persistentClass;
    private Session session;

    public AbstractDao() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public T findById(ID id) {
        return (T) getSession().load(this.getPersistentClass(), id);
    }

    protected List<T> findByCriteria(Criterion... criterion) {
        Criteria crit = this.getSession().createCriteria(this.getPersistentClass());
        for (Criterion c : criterion) {
            crit.add(c);
        }
        return crit.list();
    }

    @Override
    public List<T> findAll() {
        return this.findByCriteria();
    }

    @Override
    public T save(T entity) {
        this.getSession().saveOrUpdate(entity);
        return entity;
    }

    @Override
    public void delete(T entity) {
        this.getSession().delete(entity);
    }

    @Override
    public void flush() {
        this.getSession().flush();
    }

    @Override
    public void clear() {
        this.getSession().close();
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    protected Session getSession() {
        if (this.session == null) {
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        }
        return this.session;
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }
}
