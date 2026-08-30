<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 31/07/2022
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {
            margin: 0;
            font-family: Arial, Helvetica, sans-serif;
        }

        .hero-image {
            background-image: url("https://phonoteka.org/uploads/posts/2021-06/1624337566_6-phonoteka_org-p-superkari-oboi-krasivo-6.jpg");
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
<%@include file="includes/navbarForAdminSuperAdmin.jsp" %>

<div class="hero-image">
    <div class="hero-text">
        <h1 style="font-size:50px"></h1>
        <h3></h3>
        <div align="center">
            <h1>Super Admin Page</h1>
        </div>
        <div align="center">
            <button><a href="redirectUser">Select Admin</a><br><br></button>
            <button><a href="/add-book">Add Book</a><br><br></button>
            <button><a href="update2">Book Update</a><br><br></button>
            <button><a href="deleteBook">Delete book</a><br><br></button>
            <button><a href="signup.jsp">Add user</a><br><br></button>
            <button><a href="userPagination">User delete and update</a><br><br></button>
            <br><br>
            <button><a href="addAuthor.jsp">Add Author</a><br><br></button>
            <button><a href="viewAdmin">View Admin</a><br><br></button>
            <button><a href="books">Home page</a><br><br></button>
            <br><br>


        </div>
    </div>
</div>
</body>
</html>


</body>
</html>