<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

Corpo

10 + 20 = ${soma}

<c:url value="/report/clientes.pdf" var="clientePdfReport" />

<a href="${clientePdfReport}">Relatório de clientes (PDF)</a>