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

    private DatabaseConnection() {
        factory = Persistence.createEntityManagerFactory("fourthAppPU");
    }

    public static DatabaseConnection createInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
}
