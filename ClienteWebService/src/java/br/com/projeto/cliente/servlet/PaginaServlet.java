/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.cliente.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gilmario
 */
@WebServlet(urlPatterns = "/pagina")
public class PaginaServlet extends HttpServlet {

    private static final String PAGINA = "pagina";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pagina = req.getParameter(PAGINA);
        req.getRequestDispatcher("WEB-INF/partes/" + pagina + ".xhtml").include(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("WEB-INF/partes/" + "inicio" + ".xhtml").forward(req, resp);
    }

}
