<%--
  Created by IntelliJ IDEA.
  User: abror
  Date: 01/08/22
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>BOOK PAGE</title>
    <!--    <link rel="stylesheet" href="styles.css">-->

    <link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
</head>

<body>

<%@include file="includes/navbar.jsp" %>

<!--SAYTNI MENYUDAN PASTKI QISMI KONTENTLAR-->
<section class="container mt-4 ">


    <c:if test="${message != null}">
        <h1>${message}</h1>
    </c:if>



    <div class="row justify-content-around">

        <c:forEach items="${bookList}" var="book">
            <div class="card my-4 text-center shadow col-md-3" style="width: 18rem;">
                <img src="files/${book.getImgUrl()}" class="card-img-top" alt="${book.getTitle()}">
                <div class="card-body">
                    <h5 class="card-title">${book.getTitle()}</h5>
                    <c:forEach items="${book.getAuthors()}" var="author">
                        <a href="/authors?id=${author.getId()}">
                            <h6 class="card-title">${author.getFullName()}</h6>
                        </a>
                    </c:forEach>
                    <p class="card-text">${book.getCategory().getName()}</p>

                </div>
            </div>
        </c:forEach>

    </div>
<div align="center">
    <c:forEach begin="${1}" end="${bookSize}" var="sizeBook">

        <a href="books?page=${sizeBook}">${  sizeBook}</a>

    </c:forEach>
</div>
</section>

<!--SAYTNI PASTKI QISMI | SAYT HAQIDA YOKI KOMPANIYA HAQIDA MA'LUMOTLAR -->
<footer>

</footer>


</body>
</html>
