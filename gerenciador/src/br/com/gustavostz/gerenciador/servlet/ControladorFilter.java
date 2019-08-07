package br.com.gustavostz.gerenciador.servlet;

import br.com.gustavostz.gerenciador.acao.Acao;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter("/entrada")
public class ControladorFilter implements Filter {

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException, IOException {

        System.out.println("ControladorFilter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String paramAcao = request.getParameter("acao");
        String nomeDaClasse = "br.com.gustavostz.gerenciador.acao."+paramAcao;

        String nome = null;
        try {
            Class classe = Class.forName(nomeDaClasse); // carrega classe com o nome
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
    }
}
