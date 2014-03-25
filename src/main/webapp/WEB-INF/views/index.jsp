<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--@elvariable id="soma" type="java.lang.Integer"--%>

Testando serviço:<br>
10 + 20 = ${soma}<br>

<a href="<c:url value='/report/cliente/pdf'/>" target="_blank">Relatório de clientes (PDF)</a><br>
<a href="<c:url value='/report/cliente/xls'/>" target="_blank">Relatório de clientes (XLS)</a><br>
<a href="<c:url value='/report/cliente/html'/>" target="_blank">Relatório de clientes (HTML)</a><br>
<a href="<c:url value='/report/cliente/csv'/>" target="_blank">Relatório de clientes (CSV)</a>