<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE HTML>
<html lang="pt-br">
<head>
    <meta charset="utf-8">
    <title><tiles:insertAttribute name="title" defaultValue="<fmt:message key='app.titulo'/>" /></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Rodrigo Garcia Lima">
</head>
<body>

<tiles:insertAttribute name="header"/>
<tiles:insertAttribute name="body"/>

</body>
</html>