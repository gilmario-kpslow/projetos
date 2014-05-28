/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.docproject.seguranca;

import br.com.docproject.bean.UsuarioBean;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gilmario
 */
@WebFilter(urlPatterns = "/web/*")
public class LoginFilter implements Filter {

    @Inject
    private UsuarioBean usuarioBean;
    private List<UsuarioBean> logados;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Inicio da Filtragem");
        if (logados == null) {
            logados = new ArrayList<>();
            System.out.println("Criou lista");
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (usuarioBean.getResponsavel() == null) {
            // volta pro login
            ((HttpServletResponse) response).sendRedirect(request.getServletContext().getContextPath() + "/login.xhtml");
        } else {
            // não faz nada
        }
    }

    @Override
    public void destroy() {
        System.out.println("Fim da filtragem");
    }

}
