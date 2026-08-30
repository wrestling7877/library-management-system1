package uz.pdp.librarymanagementsystem.books;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/update2")

public class Update2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        String pageStr = req.getParameter("page");
        int page = 1;
        if (pageStr != null) {
            page = Integer.parseInt(pageStr);
        }
        int size = 0;

        List<Book> bookList = BookDao.getAllBooks(size, page);
        int bookSize = BookDao.size();
        req.setAttribute("bookList", bookList);

        if (page!=1){
            req.setAttribute("prev", page-1);
        }else {
            req.setAttribute("prev", page);
        }

        if ((page*3)>size){
            req.setAttribute("page", page);
        }else {
            req.setAttribute("page", page + 1);
        }


        req.getRequestDispatcher("showUpdate.jsp").forward(req, resp);
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


        if ((page*3)>size){
            req.setAttribute("page", page);
        }else {
            req.setAttribute("page", page + 1);
        }
        if (page!=1){
            req.setAttribute("prev", page-1);
        }else {
            req.setAttribute("prev", page);
        }


        req.getRequestDispatcher("showUpdate.jsp").forward(req, resp);



    }
}
