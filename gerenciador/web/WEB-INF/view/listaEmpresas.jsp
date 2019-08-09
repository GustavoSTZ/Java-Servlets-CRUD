<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List ,br.com.gustavostz.gerenciador.modelo.Empresa" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:import url="logout-parcial.jsp"/>

    Usuario Logado: ${ usuarioLogado.login }

    <br>
    <br>

    <c:if test="${not empty empresa}">
        Empresa ${ empresa } Cadastrada com Sucesso!
    </c:if>

    <h2>Lista Empresas:</h2>

    <ul>
        <c:forEach items="${ empresas }" var="empresa">

            <li>
                ${ empresa.nome } -  <fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy"/>
                    <a href="/gerenciador/entrada?acao=MostraEmpresa&id=${ empresa.id }">editar</a>
                    <a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${ empresa.id }">remover</a>
            </li>

        </c:forEach>
    </ul>
    <a href="http://localhost:8080/gerenciador/entrada?acao=NovaEmpresaForm" class="btn btn-success"> Registar Empresa</a>
</body>
</html>
