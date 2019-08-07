<%@ page import="br.com.gustavostz.gerenciador.modelo.Empresa" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>Nova Empresa Criada</title>
</head>
<body>
    <c:import url="logout-parcial.jsp"/>

    <c:if test="${not empty empresa}">
    Empresa ${ empresa } Cadastrada com Sucesso!
    </c:if>

    <c:if test="${ empty empresa }">
        Nenhuma Empresa Cadastrada!
    </c:if>


</body>
</html>
