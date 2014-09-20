/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevlets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author gilmario
 */
@WebServlet(urlPatterns = "/retorne", asyncSupported = true)
public class Inicio extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        final AsyncContext async = req.startAsync();
        async.start(
                new Runnable() {
                    @Override
                    public void run() {
                        ServletRequest reqs = async.getRequest();
                        ServletResponse resp = async.getResponse();
                        try {
                            reqs.getRequestDispatcher("/partes/" + reqs.getParameter("pagina") + ".html").forward(reqs, resp);
                            async.complete();
                        } catch (ServletException | IOException ex) {
                            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
        );

    }
}
