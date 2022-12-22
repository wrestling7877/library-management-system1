<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>

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
    <title>BOOK PAGE</title>
    <!--    <link rel="stylesheet" href="styles.css">-->

    <link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
</head>

<body>

<%@include file="includes/navbarForAdminSuperAdmin.jsp" %>

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

                    <a href="/update?id=${book.getId()}" > update </a>





                </div>
            </div>

        </c:forEach>

    </div>
    <div align="center">


        <%    int page1 = (int) request.getAttribute("page");
            int next = page1;
        %>
        <%    int page2= (int) request.getAttribute("prev") ;
            int prev = page2;
        %>



        <a href="update2?page=<%=prev%>">  <button class="button button2">Previous</button> </a>

        <a href="update2?page=${1}"> ${1}</a>
        <a href="update2?page=${2}"> ${2}</a>

        <a href="update2?page=<%=next%>">  <button class="button button5">Next</button> </a>



    </div>
</section>

<!--SAYTNI PASTKI QISMI | SAYT HAQIDA YOKI KOMPANIYA HAQIDA MA'LUMOTLAR -->
<footer>

</footer>


</body>
</html>