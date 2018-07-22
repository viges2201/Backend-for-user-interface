package wm1_backend.service;



import javassist.NotFoundException;
import wm1_backend.model.User;

import java.util.List;

public interface UserService {

    void create(User user);

    void delete(int id);

    User get(int id);

    void update(User user);

    List getAll();

    List<User> getFilterList(int amountOfInvestment, int amountOfRisk);
}