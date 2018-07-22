package wm1_backend.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import wm1_backend.model.User;
import wm1_backend.util.UserUtil;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void save(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        User ref = session.getReference(User.class, id);
        session.remove(ref);
    }

    @Override
    public User get(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.find(User.class, id);
        return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<User> resultList = session.createQuery("from User").getResultList();
        return resultList.stream()
                .sorted(Comparator.comparing(User::getName))
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getFilterList(int amountOfInvestment, int amountOfRisk) {
        List<User> collect = getAll().stream()
                .filter(user -> UserUtil.getFilterList((User) user, amountOfInvestment, amountOfRisk))
                .collect(Collectors.toList());
        return collect;
    }
}
