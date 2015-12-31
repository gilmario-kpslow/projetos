/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.cliente.servlet;

import br.com.projeto.cliente.controller.ResponsavelController;
import br.com.projeto.cliente.modelo.Responsavel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gilmario
 */
@WebServlet(urlPatterns = "/responsavel/salvar")
public class ResponsavelServlet extends HttpServlet {

    @EJB
    private ResponsavelController controller;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Responsavel responsavel = new Responsavel();
        responsavel.setLogin(req.getParameter("nome_usuario"));
        responsavel.setNomeCompleto(req.getParameter("nome_completo_usuario"));
        responsavel.setSenha(req.getParameter("senha_usuario"));
        responsavel.setAtivo(Boolean.TRUE);
        try (PrintWriter writer = resp.getWriter()) {
            writer.print(controller.salvar(responsavel));
        }

    }

}
