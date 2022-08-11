<%@ page import="java.io.PrintWriter" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 03/08/2022
  Time: 05:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>


    <style>
        .button {
            background-color: #4CAF50; /* Green */
            border: none;
            color: white;
            padding: 15px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 8px;
            margin: 4px 2px;
            cursor: pointer;
        }

        .button2 {background-color: #008CBA;} /* Blue */
        .button2 {border-radius: 12px;}
        .button5 {border-radius: 12px;}
        .button5 {background-color: #555555;} /* Black */
    </style>
</head>
<body>


<table>
    <tr>
        <th> N%</th>
        <th> Username</th>
        <th> Password</th>
        <th>FullName</th>
        <th>Role</th>
        <th>Select Admin</th>
    </tr>


   <% int n = (int) request.getAttribute("n");  %>  <%--  scriplate--%>

    <c:forEach items="${userList}" var="user" >

<%--        exprewwin--%>
        <tr>
            <td><%=     n++      %></td>
            <td>${user.getUsername()}</td>
            <td>${user.getFullName()}</td>
            <td>${user.getPassword()}</td>
            <td>${user.getRole()}</td>


            <td>  <button><a href="superAdmin?id=${user.getId()}"> Select</a></button>  </td>






        </tr>

    </c:forEach>

</table>
<div align="center">

    <%    int page1 = (int) request.getAttribute("page");
          int next = page1;
    %>
    <%    int page2= (int) request.getAttribute("prev") ;
          int prev = page2;
    %>



    <a href="redirectUser?page=<%=prev%>">  <button class="button button2">Previous</button> </a>

    <a href="redirectUser?page=${1}"> ${1}</a>
    <a href="redirectUser?page=${2}"> ${2}</a>

    <a href="redirectUser?page=<%=next%>">  <button class="button button5">Next</button> </a>

</div>
<button><a href="superAdminPage.jsp">back</a></button>
</body>
</html>