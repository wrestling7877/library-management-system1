<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 31/07/2022
  Time: 02:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>

<%--    <%@page import="uz.pdp.librarymanagementsystem.book_strore_2.welcome.Welcome" %>--%>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {
            margin: 0;
            font-family: Arial, Helvetica, sans-serif;
        }

        .hero-image {
            background-image: url("https://s01.yapfiles.ru/files/1990311/polenebogorizontpeyzazh.jpg");
            background-color: #cccccc;
            height: 600px;
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
            position: relative;
        }

        .hero-text {
            text-align: center;
            position: absolute;
            top: 30%;
            left: 50%;
            transform: translate(-50%, -50%);
            color: white;
        }
    </style>
</head>
<body>
<div class="hero-image">
    <div class="hero-text">
        <h1 style="font-size:50px"></h1>
        <h3></h3>
        <div align="center">
            <form action = "signup" method="post">

                <input type="text" name="username"placeholder="Enter Username" required><br><br>

                <input type="text" name="password"placeholder="Enter password" required><br><br>

                <input type="text" name="fullName"placeholder="Enter FullName" required><br><br>

                <input type="submit" value="Signup"><br><br>

                <br>
                <button> <a href="https://www.instagram.com/wrestling_7877/"> Wrestling7877</a> </button>
            </form>
            <br>
        </div>
    </div>
</div>
</body>
</html>


</body>
</html>