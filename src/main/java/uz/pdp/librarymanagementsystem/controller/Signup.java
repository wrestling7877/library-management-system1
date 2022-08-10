package uz.pdp.book_strore_2.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.book_strore_2.entity.User;
import uz.pdp.book_strore_2.service.UserService;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/signup")
public class Signup extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String fullName = req.getParameter("fullName");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setFullName(fullName);
        int status = UserService.saveUser(user);
        int userId =  UserService.getId(username);
        int roleId = UserService.getRoleId("User");
        UserService.saveRole(userId,roleId);


        if (status != 0) {

            printWriter.println("<center> <p style = \"color:green\">registration was successful</p> </center>");
            req.getRequestDispatcher("login.jsp").include(req,resp);


        } else {
            printWriter.println("<center> <p style = \"color:red\"> username is already used!!!</p> </center>");
            req.getRequestDispatcher("signup.jsp").include(req, resp);


        }
    }


}
