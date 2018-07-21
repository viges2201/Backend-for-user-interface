package wm1_backend.repository;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.transaction.annotation.Transactional;
import wm1_backend.model.User;
import java.util.List;

@Transactional(readOnly = true)
public class HibernateRepositoryImpl implements UserRepository {

    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }


    private static void shutdown() {
        ourSessionFactory.close();
    }


    private Session openSession() {
        return ourSessionFactory.openSession();
    }


    @Override
    @Transactional
    public void save(User user) {
        Session session = openSession();
        session.beginTransaction();
        if (user.isNew()) {
            session.persist(user);
            session.getTransaction().commit();
            shutdown();
        } else {
            User user1 = (User) session.merge(user);
            session.getTransaction().commit();
            shutdown();
        }
    }

    @Override
    public User get(int id) {
        Session session = openSession();
        User user = session.find(User.class, id);
        shutdown();
        return user;
    }

    @Override
    @Transactional
    public void delete(int id) {
        Session session = openSession();
        session.beginTransaction();

        User ref = session.getReference(User.class, id);
        session.remove(ref);
        session.getTransaction().commit();
        shutdown();
    }

    @Override
    public List<User> getAll() {
        Session session = openSession();

        List resultList = session.createQuery("from User").getResultList();

//        select id,name,lastName,patronymic,amountOfInvestment,amountOfRisk,term,comments from User

        shutdown();
        return resultList;
    }
}