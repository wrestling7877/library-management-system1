package uz.pdp.librarymanagementsystem.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/userUpdate")
public class UserUpdate extends HttpServlet {
    static Integer userId = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        userId = Integer.valueOf(req.getParameter("id"));

        User user = UserService.getUserById(userId);

        printWriter.println("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "\n" +
                "\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "    <style>\n" +
                "        body {\n" +
                "            margin: 0;\n" +
                "            font-family: Arial, Helvetica, sans-serif;\n" +
                "        }\n" +
                "\n" +
                "        .hero-image {\n" +
                "            background-image: url(\"https://s01.yapfiles.ru/files/1990311/polenebogorizontpeyzazh.jpg\");\n" +
                "            background-color: #cccccc;\n" +
                "            height: 600px;\n" +
                "            background-position: center;\n" +
                "            background-repeat: no-repeat;\n" +
                "            background-size: cover;\n" +
                "            position: relative;\n" +
                "        }\n" +
                "\n" +
                "        .hero-text {\n" +
                "            text-align: center;\n" +
                "            position: absolute;\n" +
                "            top: 30%;\n" +
                "            left: 50%;\n" +
                "            transform: translate(-50%, -50%);\n" +
                "            color: white;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"hero-image\">\n" +
                "    <div class=\"hero-text\">\n" +
                "        <h1 style=\"font-size:50px\"></h1>\n" +
                "        <h3></h3>\n" +
                "        <div align=\"center\">\n" +
                "            <form action = \"userUpdate\" method=\"post\">\n" +
                "\n" +
                "                <input type=\"text\" name=\"username\"value=\" " + user.getUsername() + "\" Enter Username\" required><br><br>\n" +
                "\n" +
                "                <input type=\"text\" name=\"password\"value=\"" + user.getPassword() + "\"Enter password\" required><br><br>\n" +
                "\n" +
                "                <input type=\"text\" name=\"fullName\"value=\"" + user.getFullName() + "\"Enter FullName\" required><br><br>\n" +
                "\n" +
                "                <input type=\"submit\" value=\"Save\"><br><br>\n" +
                "\n" +
                "                <br>\n" +

                "            </form>\n" +
                "            <br>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>\n" +
                "\n" +
                "\n" +
                "</body>\n" +
                "</html>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = User.builder()
                .id(userId)
                .username(req.getParameter("username"))
                .password(req.getParameter("password"))
                .fullName(req.getParameter("fullName"))
                .build();


        UserService.userUpdate(user);


            resp.sendRedirect("userPagination");




    }
}
