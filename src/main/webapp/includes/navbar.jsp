<%--
  Created by IntelliJ IDEA.
  User: abror
  Date: 02/08/22
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Navbar</title>
    <link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
</head>
<body>
<!--NAVIGATION BAR | SAYTNI MENYU QISMI-->
<nav class="navbar navbar-dark bg-dark">

    <div class="logo">
        <h1 class="text-white">MY LIBRARY</h1>
    </div>
    <div class="menu">
        <ul class="d-flex">
            <li class="mx-3"><a href="/adminPage.jsp">Books</a></li>
            <li class="mx-3"><a href="/issue-return-book">Issue/Return a book</a></li>
            <li class="mx-3"><a href="/students">Students</a></li>
            <li class="mx-3"><a href="/reports">Reports</a></li>
        </ul>
    </div>
    <div class="search">
        <label for="search-book">Search:</label>
        <input id="search-book" type="text" placeholder="ex. Shaytanat">
    </div>
    <div class="profile-image ">
        <img class="rounded-circle " src="images/img.png" width="60px" height="60px" alt="">
    </div>
</nav>
</body>
</html>
