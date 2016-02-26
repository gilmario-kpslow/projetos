package br.com.truesystem.projetosweb.seguranca;

import br.com.truesystem.projetosweb.negocio.ResponsavelSession;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gilmario
 */
@WebServlet(urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {

    @Inject
    private ResponsavelSession session;

    private void destruirSessao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session.setResponsavel(null);
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        request.setAttribute("mensagem", "Você foi deslogado corretamente.");
        request.getRequestDispatcher("/login.xhtml").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        destruirSessao(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        destruirSessao(req, resp);
    }

}
