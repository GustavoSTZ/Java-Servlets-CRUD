package br.com.gustavostz.gerenciador.acao;

import br.com.gustavostz.gerenciador.modelo.Banco;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveEmpresa {
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("removendo empresa");

        String paramId = request.getParameter("id");
        Integer id = Integer.valueOf(paramId);

        System.out.println(id);

        Banco banco = new Banco();
        banco.removeEmpresa(id);

        return "redirect:entrada?acao=ListaEmpresas";

    }
}
