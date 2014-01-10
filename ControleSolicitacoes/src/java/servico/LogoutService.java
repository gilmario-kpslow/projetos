/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import controler.UsuarioMB;
import java.io.IOException;
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
@WebServlet(urlPatterns = {"/logout"})
public class LogoutService extends HttpServlet {

    @Inject
    private UsuarioMB usuarioMb;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        usuarioMb.setResponsavel(null);
        ((HttpServletRequest) req).getSession().invalidate();
        resp.sendRedirect(req.getContextPath() + "/index.xhtml");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        usuarioMb.setResponsavel(null);
        resp.sendRedirect(req.getContextPath() + "/index.xhtml");
    }

}
