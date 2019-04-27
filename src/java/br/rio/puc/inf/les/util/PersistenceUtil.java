package br.rio.puc.inf.les.util;

/**
 * *
 * Fabrica de EntityManager EntityManager e o servico central para todas as
 * entidades de persistencia.
 */
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.eclipse.persistence.sessions.Session;

public class PersistenceUtil {

    private static final String PERSISTENCE_UNIT_NAME = "hibernate-persistence";
    private static EntityManagerFactory FACTORY;
    private static ThreadLocal<EntityManager> MANAGER = new ThreadLocal<EntityManager>();
    private static Session session;

    static {
        if (FACTORY == null) {
            try {
                FACTORY = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            } catch (Throwable e) {
                System.out.println("A criacao o do EntityManagerFactory falhou: " + e);
                throw new ExceptionInInitializerError(e);
            }
        }
    }

    public static EntityManager getEntityManager() {
        EntityManager em = MANAGER.get();

        if (em == null) {
            em = FACTORY.createEntityManager();
            MANAGER.set(em);
        }
        return em;
    }

    public static void closeEntityManager() {
        EntityManager em = MANAGER.get();

        if (em != null) {
            em.close();
        }
        MANAGER.set(null);
    }

    public static Session getSession() {
        if (session == null) {
            //SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
            //session = factory.openSession();

            // Pega a sessao a partir do EntityManager  
            session = (Session) getEntityManager().getDelegate();
        }
        return session;
    }
}
