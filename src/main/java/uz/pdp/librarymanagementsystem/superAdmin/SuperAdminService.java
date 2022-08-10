package uz.pdp.librarymanagementsystem.superAdmin;

import uz.pdp.librarymanagementsystem.db.DbConnection;
import uz.pdp.librarymanagementsystem.user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SuperAdminService {

    public static List<User> getAdmin() {
        List<User>userList = new ArrayList<>();

        Connection connection1 = DbConnection.getConnection();
        try {
            PreparedStatement preparedStatement1 = connection1.prepareStatement("  select users.id,  users.username,users.password,users.fullname,roles.name" +
                    " from users join users_roles ur on ur.user_id=users.id " +
                    "join roles on roles.id=ur.role_id where roles.name='Admin';");
            ResultSet resultSet = preparedStatement1.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setFullName(resultSet.getString(4));


                userList.add(user);
            }

            connection1.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);


        }

        return userList;
    }


    public static void selectAdmin(Integer id) {
        try {
            Connection connection1 = DbConnection.getConnection();


            PreparedStatement preparedStatement = connection1.prepareStatement("update users_roles set role_id = 1 where user_id=?");
            preparedStatement.setInt(1,id);
            preparedStatement.execute();

            connection1.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void removeAdmin(Integer id) {


        Connection connection1 = DbConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection1.prepareStatement("update users_roles set role_id = 3 where user_id = ?");
            preparedStatement.setLong(1,id);
            preparedStatement.execute();
            connection1.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

