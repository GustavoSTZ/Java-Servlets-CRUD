<%@ page import="br.com.gustavostz.gerenciador.modelo.Empresa" %><%--
  Created by IntelliJ IDEA.
  User: Pc Gamer
  Date: 8/4/2019
  Time: 4:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>Nova Empresa Criada</title>
</head>
<body>
    <c:if test="${not empty empresa}">
    Empresa ${ empresa } Cadastrada com Sucesso!
    </c:if>

    <c:if test="${ empty empresa }">
        Nenhuma Empresa Cadastrada!
    </c:if>


</body>
</html>
