
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
</head>
<body>


<table>
    <tr>
        <th> N%</th>
        <th>FullName</th>
        <th>Title</th>
        <th>Data</th>
    </tr>


    <% int n = 1; %>
    <c:forEach items="${myBooks}" var="isued">


        <tr>
            <td><%=    n++   %> </td>

            <td>${isued.getFullName()}</td>
            <td>${isued.getTitle()}</td>
            <td>${isued.getDate()}</td>




        </tr>

    </c:forEach>


</table>
<a href="userPage1.jsp">back</a>
</body>
</div>
</html>