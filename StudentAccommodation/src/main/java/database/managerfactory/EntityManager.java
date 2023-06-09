package database.managerfactory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManager {
    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

    private EntityManager() {
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static void close() {
        entityManagerFactory.close();
    }
}