package uz.pdp.librarymanagementsystem.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/userPagination")
public class UsersPagination extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String page_jsp = req.getParameter("page");
        int page = 1;
        if (page_jsp != null) page = Integer.parseInt(page_jsp);

        int n = page;
        int page1 = page;

        if (n != 1) {
            n = n * 3 - 2;
        }
        List<User> userList = UserService.getAllUsers(page);
        int size = UserService.usersSize();
        req.setAttribute("n",n);
        req.setAttribute("userList", userList);
        if (page!=1){
            req.setAttribute("prev", page1-1);
        }else {
            req.setAttribute("prev", page1);
        }

        if ((page*3)>size){
            req.setAttribute("page", page);
        }else {
            req.setAttribute("page", page + 1);
        }
        req.getRequestDispatcher("updateDeleteUser.jsp").forward(req, resp);
    }
}
