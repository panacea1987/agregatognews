<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/tableStyle.css">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/main.css">
    <link rel="shortcut icon" href="${pageContext.servletContext.contextPath}/image/favicon.ico" type="image/x-icon">
    <title>Выбраные новости</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
</head>
<body>
<c:set var="count" value="0"/>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="http://localhost:8080/">
                <i class="fa fa-home" aria-hidden="true"></i>АгрегаторNews</a>
        </div>
    </div>
</div>
<br>
<div class="test">
    <div>
        <table class="tg1">
            <tr class="tg1">
                <th>№</th>
                <th>Сайт</th>
                <th>Картинка</th>
                <th>Новость</th>
                <th>Дата публикации</th>
            </tr>
            <c:if test="${!empty singlenews}">
                <c:forEach items="${singlenews}" var="news">
                    <c:set var="count" value="${count+1}"/>
                    <tr class="active tg1">
                        <td>${count}</td>
                        <td>${news.getUrlNews()}</td>
                        <td><img src="${news.getLinkImgNews()}" width="160"></td>
                        <td><a href="${news.getLinkNews()}">${news.getHeaderNews()}</a></td>
                        <td>${news.getDateTimeNews()}</td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>
