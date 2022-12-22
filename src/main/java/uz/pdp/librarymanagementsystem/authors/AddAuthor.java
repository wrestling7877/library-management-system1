package uz.pdp.librarymanagementsystem.authors;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/addAuthor")
public class AddAuthor extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

String fullName = req.getParameter("fullName");
String biography = req.getParameter("biography");
AuthorDao.saveAuthor(fullName,biography);
req.getRequestDispatcher("adminPage.jsp").forward(req,resp);
    }
}
