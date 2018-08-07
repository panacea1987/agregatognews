<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8" content="text/html">
    <title>Аааагрегатор</title>
    <link rel="shortcut icon" href="${pageContext.servletContext.contextPath}/image/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/main.css">
</head>
<body>
<div>
    <form class="form-3" method="get" id="url" action="/newslink/">
        <p class="clearfix">
            <label for="urlsite">Введите адрес сайта</label>
            <input type="text" name="url" id="urlsite" placeholder="www.." required>
        </p>
        <p>
            <label for="rules">Введите правила парсинга</label>
            <textarea id="rules" cols="35" rows="20" name="rules" required></textarea>
        </p>
        <p class="clearfix">
            <input type="submit" name="submit" value="Искать" form="url">
        </p>

    </form>
</div>
</body>