package uz.pdp.book_strore_2.service;


import uz.pdp.book_strore_2.db.Database;
import uz.pdp.book_strore_2.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserService {

    static Connection connection = Database.getConnection();
    static PreparedStatement preparedStatement = null;
    static ResultSet resultSet = null;
    static int user_id = 0;
    static Integer role_id = 0;
    static String roleName2;

    public static String getRoleName() {
        return roleName2;
    }

    public static int saveUser(User user) {

        int statusUser = 0;
        Connection connection1 = Database.getConnection();

        try {

            // TODO: 31/07/2022 save user
            PreparedStatement preparedStatement = connection1.prepareStatement("insert into users(username, password,fullname)values(?,?,?)");

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFullName());
            statusUser = preparedStatement.executeUpdate();


            connection1.close();

        } catch (SQLException e) {
            return statusUser = 0;
        }

        return statusUser;
    }


    public static int getId(String username) {
        Connection connection2 = Database.getConnection();
        try {
            PreparedStatement preparedStatement = connection2.prepareStatement("select id from users where username =?");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user_id = resultSet.getInt(1);
            }
            connection2.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // TODO: 31/07/2022 get user role id


        return user_id;
    }


    public static int getRoleId(String roleName) {
        Connection connection3 = Database.getConnection();
        try {
            PreparedStatement preparedStatement = connection3.prepareStatement("select id from roles where name=? ; ");
            preparedStatement.setString(1, roleName);
            ResultSet resultSet1 = preparedStatement.executeQuery();

            while (resultSet1.next()) {

                role_id = resultSet1.getInt(1);

            }
            connection3.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return role_id;
    }


    public static void saveRole(Integer userId, Integer roleId) {

        Connection connection4 = Database.getConnection();

        // TODO: 31/07/2022 save user role
        try {
            PreparedStatement preparedStatement = connection4.prepareStatement("insert into users_roles(user_id,role_id) values (?,?)");

            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, roleId);
            preparedStatement.execute();

            connection4.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static boolean checkUser(User user) {
        boolean check = false;
        Connection connection5 = Database.getConnection();
        try {

            // TODO: 31/07/2022 save user
            preparedStatement = connection5.prepareStatement("select * from users where users.username=? and users.password=?");

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                check = true;
            }
            preparedStatement.close();


            preparedStatement = connection5.prepareStatement("select id from users where username=?");
            preparedStatement.setString(1, user.getUsername());
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user_id = resultSet.getInt(1);
            }
            preparedStatement.close();


            preparedStatement = connection.prepareStatement("select  r.role_id from users_roles r where user_id=?");
            preparedStatement.setInt(1, user_id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                role_id = resultSet.getInt(1);
            }
            preparedStatement.close();


            preparedStatement = connection.prepareStatement("select name from roles where id=?");
            preparedStatement.setInt(1, role_id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                roleName2 = resultSet.getString(1);
            }
            preparedStatement.close();


            connection5.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return check;
    }
}
