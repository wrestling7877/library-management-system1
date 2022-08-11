package uz.pdp.librarymanagementsystem.books;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import uz.pdp.librarymanagementsystem.authors.Author;
import uz.pdp.librarymanagementsystem.category.Category;
import uz.pdp.librarymanagementsystem.db.DbConnection;

import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BookDao {
    static Connection connection1 = DbConnection.getConnection();


    public static int size() {
        int size = 0;
        Connection connection = DbConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from book");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                size++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return size ;

    }


    public static List<Book> getAllBooks(int size, int page) {
        int a = (page - 1) * 3;

        try {
            ArrayList<Book> bookList = new ArrayList<>();


            Connection connection = DbConnection.getConnection();


            String sql = "select b.id,\n" +
                    "       b.title,\n" +
                    "       b.quantity,\n" +
                    "       b.isbn,\n" +
                    "       b.year,\n" +
                    "       b.\"img_url\",\n" +
                    "       json_agg(\n" +
                    "               json_build_object(\n" +
                    "                       'id', a.id,\n" +
                    "                       'fullName', a.fullname)) as authors,\n" +
                    "    json_build_object('id', c.id, 'name', c.name) as category\n" +
                    "--        c.id                                     as categoryId,\n" +
                    "--        c.name                                   as categoryName\n" +
                    "from book b\n" +
                    "         join book_authors ba on b.id = ba.book_id\n" +
                    "         join author a on a.id = ba.author_id\n" +
                    "         join category c on c.id = b.category_id\n" +
                    "group by b.id, c.id, c.name, b.title\n" +
                    "limit 3 offset  '" + a + "' ";


            PreparedStatement preparedStatement = connection.prepareStatement(sql);


            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                long bookId = resultSet.getLong(1);
                String title = resultSet.getString(2);
                int quantity = resultSet.getInt(3);
                String isbn = resultSet.getString(4);
                String year = resultSet.getString(5);
                String imgUrl = resultSet.getString(6);
                Array array = resultSet.getArray(7);
                Object categoryObj = resultSet.getObject(8);
                Type listType = new TypeToken<Set<Author>>() {
                }.getType();

                Set<Author> list = new Gson().fromJson(array.toString(), listType);

                Category category = new Gson().fromJson(categoryObj.toString(), Category.class);


                Book book = Book.builder()
                        .id(bookId)
                        .title(title)
                        .authors(list)
                        .category(category)
                        .year(year)
                        .isbn(isbn)
                        .quantity(quantity)
                        .imgUrl(imgUrl)
                        .build();

                bookList.add(book);


            }
            return bookList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    // TODO: 08/08/2022
    public static List<Book> getAllBooks2() {


        try {
            ArrayList<Book> bookList = new ArrayList<>();


            Connection connection = DbConnection.getConnection();


            String sql = "select b.id,\n" +
                    "       b.title,\n" +
                    "       b.quantity,\n" +
                    "       b.isbn,\n" +
                    "       b.year,\n" +
                    "       b.\"img_url\",\n" +
                    "       json_agg(\n" +
                    "               json_build_object(\n" +
                    "                       'id', a.id,\n" +
                    "                       'fullName', a.fullname)) as authors,\n" +
                    "    json_build_object('id', c.id, 'name', c.name) as category\n" +
                    "--        c.id                                     as categoryId,\n" +
                    "--        c.name                                   as categoryName\n" +
                    "from book b\n" +
                    "         join book_authors ba on b.id = ba.book_id\n" +
                    "         join author a on a.id = ba.author_id\n" +
                    "         join category c on c.id = b.category_id\n" +
                    "group by b.id, c.id, c.name, b.title\n";


            PreparedStatement preparedStatement = connection.prepareStatement(sql);


            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                long bookId = resultSet.getLong(1);
                String title = resultSet.getString(2);
                int quantity = resultSet.getInt(3);
                String isbn = resultSet.getString(4);
                String year = resultSet.getString(5);
                String imgUrl = resultSet.getString(6);
                Array array = resultSet.getArray(7);
                Object categoryObj = resultSet.getObject(8);
                Type listType = new TypeToken<Set<Author>>() {
                }.getType();

                Set<Author> list = new Gson().fromJson(array.toString(), listType);

                Category category = new Gson().fromJson(categoryObj.toString(), Category.class);


                Book book = Book.builder()
                        .id(bookId)
                        .title(title)
                        .authors(list)
                        .category(category)
                        .year(year)
                        .isbn(isbn)
                        .quantity(quantity)
                        .imgUrl(imgUrl)
                        .build();

                bookList.add(book);


            }
            return bookList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static boolean addNewBook(Book book) {

        try {

            Connection connection = DbConnection.getConnection();


            String insertBook = "insert into book (title, description,category_id, \"img_url\",quantity,isbn,year ) VALUES " +
                    "(?, ?, ?, ?,?,?,?)";


            PreparedStatement preparedStatement1 = connection.prepareStatement(insertBook);

            preparedStatement1.setString(1, book.getTitle());
            preparedStatement1.setString(2, book.getDescription());
            preparedStatement1.setLong(3, book.getCategoryId());
            preparedStatement1.setString(4, book.getImgUrl());
            preparedStatement1.setInt(5, book.getQuantity());
            preparedStatement1.setString(6, book.getIsbn());
            preparedStatement1.setString(7, book.getYear());

            String insertBooksAuthors = "insert into book_authors VALUES ((select currval('book_id_seq')), ?)";
            PreparedStatement preparedStatement2 = connection.prepareStatement(insertBooksAuthors);

            int executeUpdate1 = preparedStatement1.executeUpdate();

            int executeUpdate2 = 0;
            for (Long authorId : book.getAuthorsIds()) {
                preparedStatement2.setLong(1, authorId);
                executeUpdate2 = preparedStatement2.executeUpdate();
            }

            return executeUpdate1 == 1 && executeUpdate2 == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    public static Boolean updateBook(Book book) {

        try {

            Connection connection = DbConnection.getConnection();

            String updateBook = "update  book set title=?,description=?,category_id=?, \"img_url\"=?,quantity=?,isbn=?,year=?  where id=? ";


            PreparedStatement preparedStatement = connection.prepareStatement(updateBook);

            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getDescription());
            preparedStatement.setInt(3, Math.toIntExact(book.getCategoryId()));
            preparedStatement.setString(4, book.getImgUrl());
            preparedStatement.setInt(5, book.getQuantity());
            preparedStatement.setString(6, book.getIsbn());
            preparedStatement.setString(7, book.getYear());
            preparedStatement.setInt(8, Math.toIntExact(book.getId()));

            int executeUpdate = preparedStatement.executeUpdate();


            PreparedStatement preparedStatement1 = connection.prepareStatement("delete  from book_authors where  book_id=?");
            preparedStatement1.setLong(1, book.getId());
            int executeUpdate1 = preparedStatement1.executeUpdate();


            String insertBooksAuthors = "insert into book_authors VALUES (?, ?)";
            PreparedStatement preparedStatement2 = connection.prepareStatement(insertBooksAuthors);


            int executeUpdate2 = 0;
            for (Long authorId : book.getAuthorsIds()) {
                preparedStatement2.setLong(1, book.getId());
                preparedStatement2.setLong(2, authorId);
                executeUpdate2 = preparedStatement2.executeUpdate();
            }

            return executeUpdate == 1 && executeUpdate2 == 1 && executeUpdate1 == 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean deleteBook(Integer id) {
        int author_id = 0;
        boolean true_or_false;
        Connection connection1 = DbConnection.getConnection();
        try {
            // TODO: 05/08/2022  get author_id bu book_id  
            PreparedStatement preparedStatement2 = connection1.prepareStatement("select author_id from book_authors where book_id=?");
            preparedStatement2.setInt(1, id);
            ResultSet resultSet1 = preparedStatement2.executeQuery();
            if (resultSet1.next()) {
                author_id = resultSet1.getInt(1);
            }
            preparedStatement2.close();


            // TODO: 05/08/2022 delete book_id and author_id from book_authors  
            PreparedStatement preparedStatement = connection1.prepareStatement("delete from book_authors where author_id=? and book_id=?");
            preparedStatement.setInt(1, author_id);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();


            // TODO: 05/08/2022 delete book by id 
            PreparedStatement preparedStatement1 = connection1.prepareStatement("delete from book where id=?");
            preparedStatement1.setLong(1, id);
            preparedStatement1.execute();
            connection1.close();
        } catch (SQLException e) {
            return true_or_false = false;
        }

        return true_or_false = true;
    }



}