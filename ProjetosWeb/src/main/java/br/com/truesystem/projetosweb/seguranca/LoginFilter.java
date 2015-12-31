package br.com.truesystem.projetosweb.seguranca;

import br.com.truesystem.projetosweb.dominio.Papel;
import br.com.truesystem.projetosweb.servico.ResponsavelSession;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author gilmario
 */
@WebFilter(urlPatterns = "/web/*")
public class LoginFilter implements Filter {

    @Inject
    private ResponsavelSession session;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (!session.isLogado()) {
            request.getRequestDispatcher("/login.xhtml").forward(request, response);
        } else {
            // Pagar as urls e filtrar de acordo com os papeis
            String path = ((HttpServletRequest) request).getRequestURI();
            boolean autorizado = false;
            for (Papel p : session.getResponsavel().getPapel()) {
                for (String pagina : p.getRegra()) {
                    if (path.contains(pagina)) {
                        autorizado = true;
                        break;
                    }
                }
                if (autorizado) {
                    break;
                }
            }
            if (autorizado) {
                chain.doFilter(request, response);
            } else {
                request.getRequestDispatcher("/erro/negado.xhtml").forward(request, response);
            }
        }
    }

    @Override
    public void destroy() {

    }

}
