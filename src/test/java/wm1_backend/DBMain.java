package wm1_backend;

import org.hibernate.Session;
import wm1_backend.model.User;

public class DBMain {

    public static void main(String[] args) {




    }

    public static void getByID(int id) {
    }

    public static void updateUser() {
        User user = new User();
        user.setId(1);
        user.setName("donald");
        user.setLastName("dack");
        user.setPatronymic("Pack");
        user.setAmountOfInvestment(2345);
        user.setAmountOfRisk(4356);
        user.setTerm(234);
        user.setComments("update");
    }

    public static User createUser() {
        User user = new User();
        user.setName("rock");
        user.setLastName("rikky");
        user.setPatronymic("Taki");
        user.setAmountOfInvestment(159876);
        user.setAmountOfRisk(36);
        user.setTerm(10);
        user.setComments("What the fuck?");
        return user;
    }
}

