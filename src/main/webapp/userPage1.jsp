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
            background-image: url("https://interesno-vse.ru/wp-content/uploads/norvegia_3.jpg");
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
<%@include file="includes/navbarForStudent.jsp"%>
<div class="hero-image">
    <div class="hero-text">
        <h1 style="font-size:50px"></h1>
        <h3></h3>
        <div align="center">


        </div>
    </div>
</div>
</body>
</html>


</body>
</html>