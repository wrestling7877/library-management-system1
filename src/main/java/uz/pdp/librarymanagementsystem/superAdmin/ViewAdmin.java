package uz.pdp.librarymanagementsystem.superAdmin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.librarymanagementsystem.user.User;

import java.io.IOException;
import java.util.List;

@WebServlet("/viewAdmin")
public class ViewAdmin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        List<User> userList = SuperAdminService.getAdmin();
        req.setAttribute("adminList", userList);
        req.getRequestDispatcher("viewAdmin.jsp").forward(req,resp);

    }
}