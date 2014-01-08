/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import controler.UsuarioMB;
import dao.ResponsavelDAO;
import java.io.IOException;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Responsavel;

/**
 *
 * @author gilmario
 */
//@WebServlet(urlPatterns = {"/login"})
public class LoginService extends HttpServlet {

    @Inject
    private UsuarioMB usuarioMb;
    @EJB
    private ResponsavelDAO ejbFacade;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String nome = req.getParameter("nome");
            String senha = req.getParameter("senha");
            Responsavel responsavel = ejbFacade.login(nome, senha);
            if (responsavel != null) {
                usuarioMb.setResponsavel(responsavel);
                resp.sendRedirect(req.getContextPath() + "/web/index.xhtml");
            } else {
                req.setAttribute("erro", "Usuario ou senha incorretos");
                resp.sendRedirect(req.getContextPath() + "/index.xhtml");
            }

        } catch (IOException e) {
            req.setAttribute("erro", "Erro na consulta");
            resp.sendRedirect(req.getContextPath() + "/index.xhtml");
        }

    }

}
