package br.com.gustavostz.gerenciador.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/entrada")
public class MonitoramentoFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("MonitoramentoFilter");
        long antes = System.currentTimeMillis();

        String acao = request.getParameter("acao");

        //executa a ação
        chain.doFilter(request,response);

        long depois = System.currentTimeMillis();
        System.out.println("Tempo de Execução da ação "+acao+": "+(depois-antes));

    }



}
