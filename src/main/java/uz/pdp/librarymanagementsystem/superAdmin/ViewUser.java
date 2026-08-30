package uz.pdp.librarymanagementsystem.superAdmin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.librarymanagementsystem.user.User;
import uz.pdp.librarymanagementsystem.user.UserService;

import java.io.IOException;
import java.util.List;
@WebServlet("/redirectUser")
public class ViewUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String page_jsp = req.getParameter("page");
        int page = 1;
        if (page_jsp != null) page = Integer.parseInt(page_jsp);

        int n = page;

        if (n != 1) {
            n = n * 3 - 2;
        }

        List<User> userList = UserService.getAllUsers(page);
        int size = UserService.usersSize();
        req.setAttribute("n",n);
        req.setAttribute("userList", userList);
        req.setAttribute("size", size);

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

        req.getRequestDispatcher("selectAdminPage.jsp").forward(req, resp);
    }
}
