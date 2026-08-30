package uz.pdp.librarymanagementsystem.issued;

import uz.pdp.librarymanagementsystem.db.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Issued_ReturnedDao {


    public static List<Issued_Returned> srb(int page) {
        int page1 = (page-1)*10;
        List<Issued_Returned> srbList = new ArrayList<>();

        Connection connection = DbConnection.getConnection();
        try {
            PreparedStatement preparedStatement1 = connection.prepareStatement(" select  ir.issued, ir.date, u.fullname, b.title from" +
                    "   issued_returned_books ir join" +
                    "  users u on  ir.student_id=u.id join " +
                    " book b on b.id=ir.book_id offset '"+page1+"' limit 10;");

            ResultSet resultSet = preparedStatement1.executeQuery();
            while (resultSet.next()) {
                Issued_Returned srb = new Issued_Returned();
                srb.setFullName(resultSet.getString(3));
                srb.setDate(String.valueOf(resultSet.getDate(2)));
                srb.setTitle(resultSet.getString(4));
                if (resultSet.getBoolean(1)) {
                    srb.setIssued("issued");
                } else {
                    srb.setIssued("returned");
                }
                srbList.add(srb);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return srbList;
    }


    public static int size() {
        int size = 0;
        Connection connection = DbConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from issued_returned_books");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                size++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
       return size;
    }

    public static void saveIssued(Issued_Returned issued_returned) {

        Connection connection = DbConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into issued_returned_books(student_id, book_id, date, issued) values (?,?,?,?)");
                  preparedStatement.setLong(1,issued_returned.getUserId());
                  preparedStatement.setLong(2,issued_returned.getBookId());
                  preparedStatement.setDate(3, Date.valueOf(issued_returned.getDate()));
                  preparedStatement.setBoolean(4, Boolean.parseBoolean(issued_returned.getIssued()));
                  preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
