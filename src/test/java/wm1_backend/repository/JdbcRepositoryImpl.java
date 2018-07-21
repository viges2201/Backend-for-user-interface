package wm1_backend.repository;

import wm1_backend.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcRepositoryImpl {
    private static final String DB_Driver = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    //    private static final String DB_URL = "jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "root";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DB_Driver);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connection is success");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Connection is lose");
        }
        return connection;
    }

    public static void deleteById(int id) {

        Connection connection = JdbcRepositoryImpl.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM users WHERE id=?");
            preparedStatement.setInt(1, id);

            int i = preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            assert preparedStatement != null;
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static User getById(int id) {
        Connection connection = JdbcRepositoryImpl.getConnection();
        PreparedStatement preparedStatement = null;
        User user = null;

        try {
            user = new User();
            preparedStatement = connection.prepareStatement("SELECT id, name, lastname, patronymic, amountofinvestment,amountofrisk, term,comments " +
                    "FROM users WHERE id=?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            /*user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setLastName(resultSet.getString("lastname"));
            user.setPatronymic(resultSet.getString("patronymic"));
            user.setAmountOfInvestment(resultSet.getInt("amountofinvestment"));
            user.setAmountOfRisk(resultSet.getInt("amountofrisk"));
            user.setTerm(resultSet.getInt("term"));
            user.setComments(resultSet.getString("comments"));*/

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            assert preparedStatement != null;
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return user;
    }

    public static List<User> getAll() {
        List<User> usersList = new ArrayList<>();
        Connection connection = JdbcRepositoryImpl.getConnection();

        String sql = "SELECT * from users";

        Statement statement = null;
        try {
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                User user = new User();

                 /*user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setLastName(resultSet.getString("lastname"));
            user.setPatronymic(resultSet.getString("patronymic"));
            user.setAmountOfInvestment(resultSet.getInt("amountofinvestment"));
            user.setAmountOfRisk(resultSet.getInt("amountofrisk"));
            user.setTerm(resultSet.getInt("term"));
            user.setComments(resultSet.getString("comments"));*/

                usersList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert statement != null;
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return usersList;
    }


}
