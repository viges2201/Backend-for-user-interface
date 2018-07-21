<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User list</title>
    <link rel="stylesheet" href="css/style.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <h3>
        <a href="index.html">Home</a>
    </h3>
    <section>
        <h2>Users</h2>
        <form method="post" action="users?action=filter">
            <dl>
                <dt>Investment more:</dt>
                <dd><input type="number" name="amountOfInvestment" value="${param.amountOfInvestment}"></dd>
            </dl>
            <dl>
                <dt>Risks more:</dt>
                <dd><input type="number" name="amountOfRisk" value="${param.amountOfRisk}"></dd>
            </dl>
            <button type="submit">Filter</button>
        </form>
        <hr/>
        <a href="users?action=create">Add User</a>
        <hr/>
        <table border="1" cellpadding="8" cellspacing="0">
            <thead>
            <tr>
                <th>name</th>
                <th>lastName</th>
                <th>patronymic</th>
                <th>amountOfInvestment</th>
                <th>amountOfRisk</th>
                <th>term</th>
                <th>comments</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
            </thead>
            <c:forEach items="${users}" var="user">
                <jsp:useBean id="user" scope="page" type="wm1_backend.model.User "/>
                <tr>
                    <td>${user.name}</td>
                    <td>${user.lastName}</td>
                    <td>${user.patronymic}</td>
                    <td>${user.amountOfInvestment}</td>
                    <td>${user.amountOfRisk}</td>
                    <td>${user.term}</td>
                    <td>${user.comments}</td>
                    <td><a href="users?action=update&id=${user.id}">Update</a></td>
                    <td><a href="users?action=delete&id=${user.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
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