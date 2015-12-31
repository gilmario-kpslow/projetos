/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.truesystem.projetosweb.seguranca;

import br.com.truesystem.projetosweb.dominio.Responsavel;
import br.com.truesystem.projetosweb.servico.ResponsavelServico;
import br.com.truesystem.projetosweb.servico.ResponsavelSession;
import br.com.truesystem.projetosweb.util.CriptografiaUtil;
import java.io.IOException;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gilmario
 */
@WebServlet(urlPatterns = {"/logar", "/login"})
public class LoginServlet extends HttpServlet {

    @EJB
    private ResponsavelServico servico;
    @Inject
    private ResponsavelSession sessao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String usuario = (String) req.getParameter("usuario_");
        String senha = CriptografiaUtil.MD5((String) req.getParameter("senha_"));
        Responsavel u = servico.logar(usuario, senha);
        if (u != null) {
            sessao.setResponsavel(u);
            req.getRequestDispatcher("/web/dashboard.xhtml").forward(req, resp);
        } else {
            req.setAttribute("mensagem", "Usuário ou senha incorretos");
            req.getRequestDispatcher("/login.xhtml").forward(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.xhtml").forward(req, resp);
    }

}
