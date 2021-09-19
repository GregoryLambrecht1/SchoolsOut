package data;

import model.Exam;
import model.Person;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.List;

public class ExamDAO {
    public Exam getExamById(Long id) throws SQLException {
        EntityManager em = EMFactory.getConnection().createEntityManager();
        return em.find(Exam.class, id);
    }

    public List<Exam> getAllExams() throws SQLException {
        EntityManager em = EMFactory.getConnection().createEntityManager();
        List<Exam> exames = em.createQuery("Select b From Exam b").getResultList();
        return exames;
    }


    public void addExam (Exam exam) throws SQLException {
        EntityManager em = EMFactory.getConnection().createEntityManager();
        em.getTransaction().begin();
        em.persist(exam);
        em.getTransaction().commit();
    }

    public void updateExam(Exam exam) throws SQLException {
        EntityManager em = EMFactory.getConnection().createEntityManager();
        em.getTransaction().begin();
        em.merge(exam);
        em.getTransaction().commit();
    }

    public void deleteExam(Exam exam) throws SQLException {
        EntityManager em = EMFactory.getConnection().createEntityManager();
        em.getTransaction().begin();
        Person foundExam = em.find(Person.class, exam.getId());
        em.remove(foundExam);
        em.getTransaction().commit();
    }
}
