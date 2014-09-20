/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sevlets.projeto;

import br.com.docproject.modelo.Projeto;
import controler.ProjetoController;
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
@WebServlet(urlPatterns = "/projeto/listar")
public class ListarProjetoServlet extends HttpServlet {

    @EJB
    private ProjetoController controller;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter writer = resp.getWriter()) {
            try {
                Projeto p = new Projeto();
                Map<String, String[]> mapa = req.getParameterMap();
                if (mapa.containsKey("nome")) {
                    p.setNome(mapa.get("nome")[0]);
                }
                if (mapa.containsKey("nome")) {
                    p.setDescricao(mapa.get("descricao")[0]);
                }
                if (mapa.containsKey("id")) {
                    p.setId(Long.parseLong(mapa.get("id")[0]));
                }
                controller.salvar(p);
                writer.println("Projeto Salvo com sucesso.");
            } catch (NumberFormatException e) {
                writer.println("Erro ao slavar Projeto." + e);
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
