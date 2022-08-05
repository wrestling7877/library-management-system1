package uz.pdp.librarymanagementsystem.authors;

import uz.pdp.librarymanagementsystem.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDao {


    public static List<Author> getAllAuthors() {


        try (Connection connection = DbConnection.getConnection();) {
            List<Author> authorList = new ArrayList<>();

            String sql = "select * from author";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String fullName = resultSet.getString("fullName");

                Author author = Author.builder()
                        .id(id)
                        .fullName(fullName)
                        .build();

                authorList.add(author);
            }

            return authorList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


public static Author author(Long id){
        Author author = new Author();

        Connection connection = DbConnection.getConnection();
    try {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from author where id=?");
        preparedStatement.setInt(1, Math.toIntExact(id));
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            author.setId((long) resultSet.getInt(1));
            author.setFullName(resultSet.getString(2));
            author.setBiography(resultSet.getString(3));
        }
        connection.close();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
return author;
}
}
