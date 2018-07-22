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
        <h2>Filter</h2>
        <form method="post" action="users?action=filter">
            <dl>
                <dt>Investment more:</dt>
                <dd><input type="number" name="amountOfInvestment" value="${param.amountOfInvestment}" required></dd>
            </dl>
            <dl>
                <dt>Risks more:</dt>
                <dd><input type="number" name="amountOfRisk" value="${param.amountOfRisk}" required></dd>
            </dl>
            <button type="submit">Filter</button>
        </form>
        <hr/>
        <a href="users?action=create">Add User</a>
        <hr/>
        <h2>Users</h2>
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
</body>
</html>