<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>User</title>
    <link rel="stylesheet" href="css/style.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <section>
        <h3><a href="index.html">Home</a></h3>
        <h2>${param.action == 'create' ? 'Create user' : 'Edit user'}</h2>
        <hr>
        <jsp:useBean id="user" type="wm1_backend.model.User" scope="request"/>
        <form method="post" action="users">
            <input type="hidden" name="id" value="${user.id}">
            <dl>
                <dt>name:</dt>
                <dd><input type="text" value="${user.name}" name="name" required></dd>
            </dl>
            <dl>
                <dt>lastName:</dt>
                <dd><input type="text" value="${user.lastName}" name="lastName" required></dd>
            </dl>
            <dl>
                <dt>patronymic:</dt>
                <dd><input type="text" value="${user.patronymic}" name="patronymic" required></dd>
            </dl>
            <dl>
                <dt>amountOfInvestment:</dt>
                <dd><input type="number" value="${user.amountOfInvestment}" name="amountOfInvestment" required></dd>
            </dl>
            <dl>
                <dt>amountOfRisk:</dt>
                <dd><input type="number" value="${user.amountOfRisk}" name="amountOfRisk" required></dd>
            </dl>
            <dl>
                <dt>term:</dt>
                <dd><input type="number" value="${user.term}" name="term" required></dd>
            </dl>
            <dl>
                <dt>comments:</dt>
                <dd><input type="text" value="${user.comments}" name="comments" required></dd>
            </dl>
            <button type="submit">Save</button>
            <button onclick="window.history.back()" type="button">Cancel</button>
        </form>
    </section>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
        integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
        crossorigin="anonymous"></script>
</body>
</html>
