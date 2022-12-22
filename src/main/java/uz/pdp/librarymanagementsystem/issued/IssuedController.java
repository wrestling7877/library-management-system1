package uz.pdp.librarymanagementsystem.issued;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
@WebServlet("/forwardIssued")
public class IssuedController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String pageStr = req.getParameter("page");
        int page = 1;
        if (pageStr != null) {
            page = Integer.parseInt(pageStr);
        }
        int n = page;

        if (n != 1) {
            n = n * 10 - 9;
        }

        List<Issued_Returned> issued_returnedList = Issued_ReturnedDao.srb(page);
        int size =Issued_ReturnedDao.size()+1;

        req.setAttribute("issued_returnedList", issued_returnedList);

        req.setAttribute("n",n);

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


        req.getRequestDispatcher("Ssued_returned_books.jsp").forward(req, resp);

    }

}
