package br.com.fourthapp.dao;

import br.com.fourthapp.connection.DatabaseConnection;
import br.com.fourthapp.util.FourthAppException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author fernando
 */
public abstract class AbstractDAO<T> implements Serializable {

    public static final int MAX_RESULTS_QUERY = 10;
    private final Class clazz;

    public AbstractDAO(Class clazz) {
        this.clazz = clazz;
    }

    public void save(T entity) {
        try {
            beginTransaction();
            getEntityManager().persist(entity);
            commitAndCloseTransaction();
        } catch (Exception ex) {
            String error = "Error to save: " + ex.getMessage();
            closeTransaction();
            throw new FourthAppException(error, ex);
        }
    }

    public void update(T entity) {
        try {
            beginTransaction();
            getEntityManager().merge(entity);
            commitAndCloseTransaction();
        } catch (Exception ex) {
            String error = "Error to update: " + ex.getMessage();
            closeTransaction();
            throw new FourthAppException(error, ex);
        }
    }

    public T merge(T entity) {
        try {
            beginTransaction();
            entity = getEntityManager().merge(entity);
            commitAndCloseTransaction();
            return entity;
        } catch (Exception ex) {
            String error = "Error to merge: " + ex.getMessage();
            closeTransaction();
            throw new FourthAppException(error, ex);
        }
    }

    public void delete(T entity) {
        try {
            beginTransaction();
            getEntityManager().remove(getEntityManager().merge(entity));
            commitAndCloseTransaction();
        } catch (Exception ex) {
            String error = "Error to delete: " + ex.getMessage();
            closeTransaction();
            throw new FourthAppException(error, ex);
        }
    }

    public void deleteAll() {
        try {
            beginTransaction();
            getEntityManager().createQuery("delete from " + clazz.getSimpleName()).executeUpdate();
            commitAndCloseTransaction();
        } catch (Exception ex) {
            String error = "Error to delete all: " + ex.getMessage();
            closeTransaction();
            throw new FourthAppException(error, ex);
        }
    }

    public T recover(Class clazz, Object id) {
        try {
            return (T) getEntityManager().find(clazz, id);
        } catch (Exception ex) {
            throw new FourthAppException(ex.getMessage(), ex);
        }
    }

    public T findById(Object id) {
        try {
            return (T) getEntityManager().find(clazz, id);
        } catch (Exception ex) {
            throw new FourthAppException(ex.getMessage(), ex);
        }
    }

    public List<T> listAll() {
        try {
            String hql = "from " + clazz.getSimpleName() + " obj order by obj.id";
            Query q = getEntityManager().createQuery(hql);
            return q.getResultList();
        } catch (Exception ex) {
            throw new FourthAppException(ex.getMessage(), ex);
        }
    }

    public int count() {
        try {
            String hql = "select count(obj.id) as amount from " + clazz.getSimpleName() + " obj";
            Query q = getEntityManager().createQuery(hql);
            Long value = (Long) q.getSingleResult();
            return value.intValue();
        } catch (Exception ex) {
            throw new FourthAppException(ex.getMessage(), ex);
        }
    }

    protected void beginTransaction() {
        getEntityManager().getTransaction().begin();
    }

    protected void commitAndCloseTransaction() {
        commit();
        closeTransaction();
    }

    protected void commit() {
        getEntityManager().getTransaction().commit();
    }

    protected void closeTransaction() {
        getEntityManager().close();
    }

    public EntityManager getEntityManager() {
        return DatabaseConnection.createInstance().getEntityManager();
    }

    public Class getClazz() {
        return clazz;
    }
}
