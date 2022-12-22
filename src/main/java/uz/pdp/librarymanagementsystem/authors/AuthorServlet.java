package uz.pdp.librarymanagementsystem.authors;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/authors")
public class AuthorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long id = Long.parseLong(req.getParameter("id"));
       Author authors1 = AuthorDao.author(id);
        List<Author>authors = new ArrayList<>();
        authors.add(authors1);
        req.setAttribute("authors",authors);
        req.getRequestDispatcher("author.jsp").forward(req,resp);


    }

}
