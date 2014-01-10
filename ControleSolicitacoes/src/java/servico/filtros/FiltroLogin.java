/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico.filtros;

import bean.AplicacaoConfiguracao;
import controler.UsuarioMB;
import java.io.IOException;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gilmario
 */
@WebFilter(urlPatterns = {"/web/*"})
public class FiltroLogin implements Filter {

    @Inject
    private UsuarioMB usuarioMb;
    @EJB
    private AplicacaoConfiguracao config;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(config.getNomeSistema());
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            if (usuarioMb.isLogado()) {
                chain.doFilter(request, response);
            } else {
                ((HttpServletResponse) response).sendRedirect(request.getServletContext().getContextPath() + "/index.xhtml");
            }
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {

    }

}
