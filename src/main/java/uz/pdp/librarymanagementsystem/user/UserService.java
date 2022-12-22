package uz.pdp.librarymanagementsystem.user;


import uz.pdp.librarymanagementsystem.db.DbConnection;
import uz.pdp.librarymanagementsystem.issued.Issued_Returned;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserService {

    static Connection connection = DbConnection.getConnection();
    static PreparedStatement preparedStatement = null;
    static ResultSet resultSet = null;
    static int user_id = 0;
    static Integer role_id = 0;
    static String roleName2;

    static String username;

    public static String getRoleName() {
        return roleName2;
    }

    public static int saveUser(User user) {

        int statusUser = 0;
        Connection connection1 = DbConnection.getConnection();

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
        Connection connection2 = DbConnection.getConnection();
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
        Connection connection3 = DbConnection.getConnection();
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

        Connection connection4 = DbConnection.getConnection();

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
        Connection connection5 = DbConnection.getConnection();
        try {

            // TODO: 31/07/2022 save user
            preparedStatement = connection5.prepareStatement("select * from users where users.username=? and users.password=?");

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                check = true;
                user_id = resultSet.getInt("id");
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

    public static List<User> getAllUserForIssued() {
        List<User> userList = new ArrayList<>();
        Connection connection1 = DbConnection.getConnection();
        try {
            PreparedStatement preparedStatement1 = connection.prepareStatement("select * from users");
            ResultSet resultSet1 = preparedStatement1.executeQuery();
            while (resultSet1.next()) {
                User user = User.builder()
                        .id(resultSet1.getInt(1))
                        .username(resultSet1.getString(2))
                        .password(resultSet1.getString(3))
                        .fullName(resultSet1.getString(4))
                        .build();
                userList.add(user);
            }

            connection1.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return userList;
    }


    // TODO: 08/08/2022 user update by id
    public static int userUpdate(User user) {
        int status = 0;
        Connection connection1 = DbConnection.getConnection();
        try {
            PreparedStatement preparedStatement1 = connection1.prepareStatement("update  users set username=?,password=?,fullname=? where id=?");
            preparedStatement1.setString(1, user.getUsername());
            preparedStatement1.setString(2, user.getPassword());
            preparedStatement1.setString(3, user.getFullName());
            preparedStatement1.setInt(4, user.getId());
            status = preparedStatement1.executeUpdate();

            connection1.close();
        } catch (SQLException e) {
            return status = 0;
        }

        return status;
    }


    // TODO: 08/08/2022  delete user by id
    public static void deleteUser(Integer id) {
        try {
            Connection connection1 = DbConnection.getConnection();
            PreparedStatement preparedStatement1 = connection1.prepareStatement("delete from users_roles where user_id=?");
            preparedStatement1.setInt(1, id);
            preparedStatement1.execute();

            PreparedStatement preparedStatement2 = connection1.prepareStatement("delete from users where id=?");
            preparedStatement2.setInt(1, id);
            preparedStatement2.execute();


            connection1.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    // TODO: 08/08/2022 get All users
    public static List<User> getAllUsers(int x) {
        int page = (x - 1) * 3;
        List<User> userList = new ArrayList<>();

        try {
            Connection connection1 = DbConnection.getConnection();
            PreparedStatement preparedStatement1 = connection1.prepareStatement(" select users.id, users.username,users.password," +
                    "users.fullname,roles.name as role from users" +

                    " join users_roles ur on ur.user_id=users.id join " +

                    "roles on roles.id=ur.role_id where roles.name not in('SuperAdmin','Admin') offset ? limit 3;");
            preparedStatement1.setInt(1, page);

            ResultSet resultSet1 = preparedStatement1.executeQuery();
            while (resultSet1.next()) {
                User user = User.builder()
                        .id(resultSet1.getInt(1))
                        .username(resultSet1.getString(2))
                        .password(resultSet1.getString(3))
                        .fullName(resultSet1.getString(4))
                        .role(resultSet1.getString(5))
                        .build();

                userList.add(user);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return userList;
    }


    // TODO: 08/08/2022 get All users size for pagination

    public static int usersSize() {
        int size = 0;
        try {
            Connection connection1 = DbConnection.getConnection();
            PreparedStatement preparedStatement1 = connection1.prepareStatement("select * from users join users_roles ur on ur.user_id=users.id " +
                    "join roles on roles.id=ur.role_id where roles.name not in('SuperAdmin','Admin');");

            ResultSet resultSet1 = preparedStatement1.executeQuery();
            while (resultSet1.next()) {
                size++;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return size ;
    }


    public static User getUserById(Integer id) {
        User user1 = new User();
        try {
            Connection connection1 = DbConnection.getConnection();
            PreparedStatement preparedStatement1 = connection1.prepareStatement("select username,fullname,password from users where id =?");
            preparedStatement1.setInt(1, id);
            ResultSet resultSet1 = preparedStatement1.executeQuery();
            while (resultSet1.next()) {
                User user = User.builder()
                        .username(resultSet1.getString(1))
                        .fullName(resultSet1.getString(2))
                        .password(resultSet1.getString(3))
                        .build();
                user1 = user;


            }

        } catch (SQLException e) {
            return user1;
        }

        return user1;
    }


    public static List<Issued_Returned> myBook() {
        List<Issued_Returned> issued_returnedList = new ArrayList<>();

        try {

            Connection connection1 = DbConnection.getConnection();
            PreparedStatement preparedStatement1 = null;

            preparedStatement1 = connection1.prepareStatement("select  ir.date, u.fullname, b.title " +
                    "from   issued_returned_books ir" +
                    " join  users u on  ir.student_id=u.id " +
                    "join  book b on b.id=ir.book_id where u.id=?;");
            preparedStatement1.setLong(1, user_id);
            ResultSet resultSet1 = preparedStatement1.executeQuery();
            while (resultSet1.next()) {
                Issued_Returned issued_returned = new Issued_Returned();

                issued_returned.setTitle(resultSet1.getString(3));
                issued_returned.setDate(String.valueOf(resultSet1.getDate(1)));
                issued_returned.setFullName(resultSet1.getString(2));
                issued_returnedList.add(issued_returned);
            }
            connection1.close();
            return issued_returnedList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


}
