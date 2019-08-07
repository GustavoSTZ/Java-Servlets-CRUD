<%--
  Created by IntelliJ IDEA.
  User: Pc Gamer
  Date: 8/4/2019
  Time: 4:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List ,br.com.gustavostz.gerenciador.modelo.Empresa" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:if test="${not empty empresa}">
        Empresa ${ empresa } Cadastrada com Sucesso!
    </c:if>

    <h2>Lista Empresas:</h2>

    <ul>
        <c:forEach items="${ empresas }" var="empresa">

            <li>
                ${ empresa.nome } -  <fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy"/>
                    <a href="/gerenciador/entrada?acao=MostraEmpresa&id=${ empresa.id }">edita</a>
                    <a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${ empresa.id }">remove</a>
            </li>

        </c:forEach>
    </ul>

</body>
</html>
