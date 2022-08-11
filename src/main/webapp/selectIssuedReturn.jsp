<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 30/07/2022
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
      <%@ page contentType="text/html;charset=UTF-8" language="java" %>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            background-image: url("https://m.games.mail.ru/hotbox/content_files/news/2020/09/22/ffe2b0e35ca740ffbee3ec6f23ab4dc7.jpg");
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

            <form action = "selectBookStudent" method="post">


              <label for="users">Student:</label>
              <select name="user" id="users" >
                <option selected disabled value="0">Select Student: </option>

                <c:forEach items="${userList }" var="user">

                  <option  value="${user.getId()}" >${user.getFullName()}</option>

                </c:forEach>

              </select>

              <br><br>

              <label for="books">Book:</label>
              <select name="book" id="books" >
                <option selected disabled value="0">Select Book: </option>
                <c:forEach items="${bookList }" var="book">

                  <option  value="${book.getId()}" >${book.getTitle()}</option>

                </c:forEach>

              </select>
              <br><br>
              <label for="date">Date</label>
              <input type="date"id="date" name="date" placeholder="date" required>

              <br><br>


              <input  type="radio" id="issued" name="issued" value="true" checked>
              <label  for="issued"> issued</label>
              <br><br>

              <input  type="radio" id="return" name="issued"value="false">
              <label  for="return"> return</label>
              <br><br>

              <input type="submit" value="Submit">
            </form>




  </form>
  <br>
  </div>
  </div>
  </div>
</body>
</html>

