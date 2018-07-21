package wm1_backend.util;

import wm1_backend.model.User;

import java.util.List;

public class UserUtil {
    public static boolean getFilterList(User user, int amountOfInvestment, int amountOfRisk) {
        return user.getAmountOfInvestment().compareTo(amountOfInvestment) > 0 && user.getAmountOfRisk().compareTo(amountOfRisk) > 0;
    }

}
