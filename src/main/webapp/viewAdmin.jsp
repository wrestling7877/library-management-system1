<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 10/08/2022
  Time: 05:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <th> Username</th>
    <th> Password</th>
    <th>FullName</th>
    <th>Remove</th>

  </tr>
   <c:forEach items="${adminList}" var="user">
  <tr>
  <td>  ${user.getUsername()}  </td>
  <td>  ${user.getFullName()}  </td>
  <td> ${ user.getPassword()}  </td>

    <td>
      <button><a href="removeAdmin?id=${user.getId()}"> Remove</a></button>
    </td>






  </tr>
  </c:forEach>

</table>

</div><button><a href=superAdminPage.jsp>back</a></button>

</body>
</html>
