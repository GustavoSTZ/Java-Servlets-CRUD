package br.com.gustavostz.gerenciador.servlet;

import br.com.gustavostz.gerenciador.acao.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String paramAcao = request.getParameter("acao");
        String nomeDaClasse = "br.com.gustavostz.gerenciador.acao."+paramAcao;

        String nome = null;
        try {
            Class classe = Class.forName(nomeDaClasse);
            Acao acao = (Acao) classe.newInstance();
            nome = acao.executa(request, response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new ServletException(e);
        }


        String[] tipoEEndereço = nome.split(":");

        if(tipoEEndereço[0].equals("forward")) {
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereço[1]);
            rd.forward(request, response);
        }else if( tipoEEndereço[0].equals("redirect"))
            response.sendRedirect(tipoEEndereço[1]);


//        if(paramAcao.equals("ListaEmpresas")) {
//
//            ListaEmpresas acao = new ListaEmpresas();
//            nome = acao.executa(request, response);
//
//        } else if(paramAcao.equals("RemoveEmpresa")) {
//
//            RemoveEmpresa acao = new RemoveEmpresa();
//            nome = acao.executa(request,response);
//
//        } else if(paramAcao.equals("MostraEmpresa")) {
//
//            MostraEmpresa acao = new MostraEmpresa();
//            nome = acao.executa(request,response);
//
//        } else if(paramAcao.equals("AlteraEmpresa")) {
//
//            AlteraEmpresa acao = new AlteraEmpresa();
//            nome = acao.executa(request,response);
//
//        } else if(paramAcao.equals("NovaEmpresa")) {
//
//            NovaEmpresa acao = new NovaEmpresa();
//            nome = acao.executa(request,response);
//
//        }else if(paramAcao.equals("NovaEmpresaForm")) {
//
//            NovaEmpresaForm acao = new NovaEmpresaForm();
//            nome = acao.executa(request,response);
//
//        }



    }
}
