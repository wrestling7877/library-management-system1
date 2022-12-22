package uz.pdp.librarymanagementsystem.issued;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.librarymanagementsystem.books.Book;
import uz.pdp.librarymanagementsystem.books.BookDao;
import uz.pdp.librarymanagementsystem.user.User;
import uz.pdp.librarymanagementsystem.user.UserService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/selectBookStudent")
public class SelectBookStudent extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<User> userList = UserService.getAllUserForIssued();
        List<Book> bookList = BookDao.getAllBooks2();

        req.setAttribute("userList", userList);
        req.setAttribute("bookList", bookList);
        req.getRequestDispatcher("selectIssuedReturn.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        Issued_Returned issued_returned = Issued_Returned.builder()
                .userId(Integer.valueOf(req.getParameter("user")))
                .bookId(Integer.valueOf(req.getParameter("book")))
                .date(req.getParameter("date"))
                .issued(req.getParameter("issued"))
                .build();

        Issued_ReturnedDao.saveIssued(issued_returned);
       // printWriter.println("issued_return was successfully");
        resp.sendRedirect("forwardIssued");
    }
}
