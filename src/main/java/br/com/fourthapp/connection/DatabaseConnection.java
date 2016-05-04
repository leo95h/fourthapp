package br.com.fourthapp.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author fernando
 */
public final class DatabaseConnection {

    private static DatabaseConnection instance;
    private static EntityManagerFactory factory;
    private EntityManager entityManager;

    private DatabaseConnection() {
        factory = Persistence.createEntityManagerFactory("fourthAppPU");
    }

    public static DatabaseConnection createInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public void closeConnection() {
        try {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
            if (instance != null) {
                instance.closeConnection();
            }
        } catch (NotValidConnectionException ex) {
        }
    }
}
