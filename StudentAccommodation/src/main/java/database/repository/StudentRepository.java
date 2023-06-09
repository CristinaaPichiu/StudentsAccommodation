package database.repository;

import database.model.StudentiEntity;
import database.managerfactory.EntityManager;

import javax.persistence.TypedQuery;
import java.util.List;

public class StudentRepository {


    /**
     * This method implements a query that displays all students in the <students> table.
     *
     * @return
     */
    public List<StudentiEntity> showAll() {
        javax.persistence.EntityManager entityManager = EntityManager.getEntityManagerFactory().createEntityManager();

        TypedQuery<StudentiEntity> query = entityManager.createNamedQuery("StudentsShowAll", StudentiEntity.class);
        List<StudentiEntity> studentsList = query.getResultList();

        entityManager.close();
        return studentsList;
    }

    /**
     * This method implements a query that displays all students in the <students> table by gender.
     *
     * @return
     */
    public List<StudentiEntity> showAllOrderByGender() {
        javax.persistence.EntityManager entityManager = EntityManager.getEntityManagerFactory().createEntityManager();

        TypedQuery<StudentiEntity> query = entityManager.createNamedQuery("StudentOrderByGender", StudentiEntity.class);
        List<StudentiEntity> orderedStudentsList = query.getResultList();

        entityManager.close();
        return orderedStudentsList;
    }

    /**
     * This method implements a query that displays all students in the home with index 1.
     *
     * @return
     */
    public List<StudentiEntity> ShowStudentsDormitory1() {
        javax.persistence.EntityManager entityManager = EntityManager.getEntityManagerFactory().createEntityManager();

        TypedQuery<StudentiEntity> query = entityManager.createNamedQuery("ShowStudentsDormitory1", StudentiEntity.class);
        List<StudentiEntity> orderedStudentsList = query.getResultList();

        entityManager.close();
        return orderedStudentsList;
    }

    /**
     * This method implements a query that displays all students in the home with index 2.
     *
     * @return
     */
    public List<StudentiEntity> ShowStudentsDormitory2() {
        javax.persistence.EntityManager entityManager = EntityManager.getEntityManagerFactory().createEntityManager();

        TypedQuery<StudentiEntity> query = entityManager.createNamedQuery("ShowStudentsDormitory2", StudentiEntity.class);
        List<StudentiEntity> orderedStudentsList = query.getResultList();

        entityManager.close();
        return orderedStudentsList;
    }

    /**
     * This method implements a query that displays all students in the home with index 3.
     *
     * @return
     */
    public List<StudentiEntity> ShowStudentsDormitory3() {
        javax.persistence.EntityManager entityManager = EntityManager.getEntityManagerFactory().createEntityManager();

        TypedQuery<StudentiEntity> query = entityManager.createNamedQuery("ShowStudentsDormitory3", StudentiEntity.class);
        List<StudentiEntity> orderedStudentsList = query.getResultList();

        entityManager.close();
        return orderedStudentsList;
    }

    /**
     * This method implements a query that displays all students in the home with index 4.
     *
     * @return
     */
    public List<StudentiEntity> ShowStudentsDormitory4() {
        javax.persistence.EntityManager entityManager = EntityManager.getEntityManagerFactory().createEntityManager();

        TypedQuery<StudentiEntity> query = entityManager.createNamedQuery("ShowStudentsDormitory4", StudentiEntity.class);
        List<StudentiEntity> orderedStudentsList = query.getResultList();

        entityManager.close();
        return orderedStudentsList;
    }

    /**
     * This method implements a query that displays all students in the home with index 5.
     *
     * @return
     */
    public List<StudentiEntity> ShowStudentsDormitory5() {
        javax.persistence.EntityManager entityManager = EntityManager.getEntityManagerFactory().createEntityManager();

        TypedQuery<StudentiEntity> query = entityManager.createNamedQuery("ShowStudentsDormitory5", StudentiEntity.class);
        List<StudentiEntity> orderedStudentsList = query.getResultList();

        entityManager.close();
        return orderedStudentsList;
    }
}
