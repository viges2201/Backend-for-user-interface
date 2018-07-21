package wm1_backend.repository;


import wm1_backend.model.User;
import java.util.List;

public interface UserRepository {
    void save(User user);

    void delete(int id);

    // null if not found
    User get(int id);

    List getAll();

    List<User> getFilterList(int amountOfInvestment, int amountOfRisk);
}