package br.com.gustavostz.gerenciador.servlet;

import br.com.gustavostz.gerenciador.modelo.Banco;
import br.com.gustavostz.gerenciador.modelo.Empresa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {

    private static final long serialVersionUID= 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Cadastrando nova Empresa");

        String nomeEmpresa = req.getParameter("nome");
        String paramDataEmpresa = req.getParameter("data");


        Date dataAbertura = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dataAbertura = sdf.parse(paramDataEmpresa);
        } catch (ParseException e) {
            throw new ServletException("e");
        }

        Empresa empresa = new Empresa();
        empresa.setNome(nomeEmpresa);
        empresa.setDataAbertura(dataAbertura);

        Banco banco = new Banco();
        banco.adiciona(empresa);

        req.setAttribute("empresa", empresa.getNome());

        resp.sendRedirect("listaEmpresas");

//        RequestDispatcher rd = req.getRequestDispatcher("/listaEmpresas");
//        req.setAttribute("empresa", empresa.getNome());
//        rd.forward(req, resp);
    }

}
