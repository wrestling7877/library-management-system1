package uz.pdp.librarymanagementsystem.books;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/deleteBook")
public class DeleteBook extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();

        String pageStr = req.getParameter("page");
        int page = 1;
        if (pageStr != null) {
            page = Integer.parseInt(pageStr);
        }
        int size12 = 6;

        List<Book> bookList = BookDao.getAllBooks(size12, page);
        int size = BookDao.size();
        req.setAttribute("bookList", bookList);

        if (page != 1) {
            req.setAttribute("prev", page - 1);
        } else {
            req.setAttribute("prev", page);
        }

        if ((page * 3) > size) {
            req.setAttribute("page", page);
        } else {
            req.setAttribute("page", page + 1);
        }

        boolean istrue = (boolean) req.getAttribute("istrue");
        if (!istrue) {

            printWriter.println("  <h1> this book is taken</h1>");
            req.getRequestDispatcher("deleteBook.jsp").include(req, resp);
        }
        req.getRequestDispatcher("deleteBook.jsp").include(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String pageStr = req.getParameter("page");
        int page = 1;
        if (pageStr != null) {
            page = Integer.parseInt(pageStr);
        }
        int size12 = 6;

        List<Book> bookList = BookDao.getAllBooks(size12, page);
        int size = BookDao.size();
        req.setAttribute("bookList", bookList);

        if (page != 1) {
            req.setAttribute("prev", page - 1);
        } else {
            req.setAttribute("prev", page);
        }

        if ((page * 3) > size) {
            req.setAttribute("page", page);
        } else {
            req.setAttribute("page", page + 1);
        }
        req.getRequestDispatcher("deleteBook.jsp").forward(req, resp);

    }
}
