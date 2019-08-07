package br.com.gustavostz.gerenciador.servlet;

import br.com.gustavostz.gerenciador.acao.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String paramAcao = request.getParameter("acao");

        String nome = null;

        if(paramAcao.equals("ListaEmpresas")) {

            ListaEmpresas acao = new ListaEmpresas();
            nome = acao.executa(request, response);

        } else if(paramAcao.equals("RemoveEmpresa")) {

            RemoveEmpresa acao = new RemoveEmpresa();
            nome = acao.executa(request,response);

        } else if(paramAcao.equals("MostraEmpresa")) {

            MostraEmpresa acao = new MostraEmpresa();
            nome = acao.executa(request,response);

        } else if(paramAcao.equals("AlteraEmpresa")) {

            AlteraEmpresa acao = new AlteraEmpresa();
            nome = acao.executa(request,response);

        } else if(paramAcao.equals("NovaEmpresa")) {

            NovaEmpresa acao = new NovaEmpresa();
            nome = acao.executa(request,response);

        }

        String[] tipoEEndereço = nome.split(":");

        if(tipoEEndereço[0].equals("foward")) {
            RequestDispatcher rd = request.getRequestDispatcher(tipoEEndereço[1]);
            rd.forward(request, response);
        }else if( tipoEEndereço[0].equals("redirect"))
            response.sendRedirect(tipoEEndereço[1]);

    }
}
