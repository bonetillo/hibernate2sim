package dao;

import models.Comentario;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

public class ComentarioDAOImpl implements ComentarioDAO {
    @Override
    public void createComentario(Comentario comentario) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(comentario);
            transaction.commit();
        } catch (HibernateError exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println(exception.getMessage());
        }

    }
}
