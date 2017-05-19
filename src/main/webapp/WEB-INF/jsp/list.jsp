<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>SCORES:</h1>
<table>
    <thead>
    <tr>
        <td>id</td>
        <td>sname</td>
        <td>course</td>
        <td>score</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="score" items="scores">
        <tr>
            <td>${score.id}</td>
            <td>${score.sname}</td>
            <td>${score.course}</td>
            <td>${score.score}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
