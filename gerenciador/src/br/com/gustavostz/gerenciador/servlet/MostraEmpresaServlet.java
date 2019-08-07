package br.com.gustavostz.gerenciador.servlet;

import br.com.gustavostz.gerenciador.modelo.Banco;
import br.com.gustavostz.gerenciador.modelo.Empresa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/mostraEmpresa")
public class MostraEmpresaServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String paramId = request.getParameter("id");
        Integer id = Integer.valueOf(paramId);

        Banco banco = new Banco();
        Empresa empresa = banco.buscaEmpresaPelaId(id);

        System.out.println(empresa.getNome());

        request.setAttribute("empresa",empresa);

        RequestDispatcher rd = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
        rd.forward(request, response);

    }
}
