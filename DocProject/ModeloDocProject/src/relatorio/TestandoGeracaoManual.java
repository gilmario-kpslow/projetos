/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.docproject.modelo.Capa;
import br.com.docproject.modelo.Conteudo;
import br.com.docproject.modelo.Historico;
import br.com.docproject.modelo.Manual;
import br.com.docproject.modelo.Pagina;
import br.com.docproject.modelo.Responsavel;
import br.com.docproject.modelo.TipoPagina;
import br.com.docproject.modelo.Topico;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author gilmario
 */
public class TestandoGeracaoManual {

    public static void main(String[] args) {

        Manual m = new Manual();
        m.setVersao("Versão 1.1");
        m.setNome("Documento de Visão");
        m.setNomeSistema("Sistema de Administração Financeira - SIAFI");
        m.setObservacao("Projeto Inicial");
        m.setRodape("Secretaria de Finanças, Planejamento e Orçamento");

        Capa c = new Capa();
        c.setCabecalho("Secretaria de Finanças, Planejamento e Orçamento");
        c.setTitulo("Sistema de Administração Financeira - SIAFI");
        c.setSubTitulo("Descrição de Mnemônicos");

        Responsavel r = new Responsavel();
        r.setNomeCompleto("gilmario");

        Responsavel r1 = new Responsavel();
        r1.setNomeCompleto("ari");

        Historico h = new Historico();
        h.setResponsavel(r);
        h.setDataVersao(new Date());
        h.setDescricao("Descrição");
        h.setVersao("1.1");

        Historico h2 = new Historico();
        h2.setResponsavel(r1);
        h2.setDataVersao(new Date());
        h2.setDescricao("Alteração N");
        h2.setVersao("1.2");

        Pagina p = new Pagina();
        p.setManual(m);
        p.getValor().add(c);
        c.setPagina(p);
        p.setTipoPagina(TipoPagina.Capa);

        Pagina p2 = new Pagina();
        p2.setManual(m);
        p2.getValor().add(h);
        p2.getValor().add(h2);
        p2.setTipoPagina(TipoPagina.Historico);

        Pagina p3 = new Pagina();
        p3.setManual(m);
        p3.setTipoPagina(TipoPagina.Sumario);

        Conteudo c1 = new Conteudo();
        c1.setTitulo("Introdução");
        c1.setNumero("1");
        c1.setTexto("");

        Conteudo c3 = new Conteudo();
        c3.setTitulo("Descrição dos Stakeholders e dos Usuários");
        c3.setNumero("3");
        c3.setTexto("");

        Conteudo c4 = new Conteudo();
        c4.setTitulo("Visão Geral do Produto");
        c4.setNumero("4");
        c4.setTexto("");

        Topico t = new Topico();
        t.setNumero("1");
        t.setTitulo("Finalidade");
        t.setConteudo(c1);
        t.setTexto("A finalidade deste documento é definir a visão que os stakeholders têm do produto, em termos de suas necessidades e das funcionalidades para atendê-las. O documento contém uma visão geral dos requisitos mais importantes do projeto.");

        Topico t2 = new Topico();
        t2.setNumero("2");
        t2.setTitulo("Finalidade do Escopo");
        t2.setConteudo(c1);
        t2.setTexto("Este documento de visão se aplica ao Sistema de Administração Financeira - SIAFI. O projeto SIAFI tem por objetivo a implementação de tecnologias para aperfeiçoar as rotinas de administração financeira nos órgãos públicos.");
        List<Topico> listaTopicos = new ArrayList<>();
        listaTopicos.add(t);
        listaTopicos.add(t2);
//        c1.setListaTopico(listaTopicos);

        Conteudo c2 = new Conteudo();
        c2.setTexto("");
        c2.setTitulo("Contextualização");
        c2.setNumero("2");
        Topico t3 = new Topico();
        t3.setNumero("1");
        t3.setTitulo("Descrição do Problema");
        t3.setConteudo(c2);
        t3.setTexto("");
        List<Topico> listaTopicos1 = new ArrayList<>();
        listaTopicos1.add(t3);
//        c2.setListaTopico(listaTopicos1);

        Pagina p4 = new Pagina();
        p4.setManual(m);
        p4.setTipoPagina(TipoPagina.Conteudo);
        p4.getValor().add(c1);
        p4.getValor().add(c2);
        p4.getValor().add(c3);
        p4.getValor().add(c4);

        try {
            List<Pagina> lista = new ArrayList<>();
            lista.add(p);
            lista.add(p2);
            lista.add(p4);
            List<Historico> listaHistorico = new ArrayList<>();
            listaHistorico.add(h);

            Map<String, Object> parametros = new HashMap<>();
            String arquivo = "/home/gilmario/Projetos/NetBeansProjects/DocProject/web/WEB-INF/relatorios/manual.jasper";
            parametros.put("REPORT_LOCALE", new Locale("pt", "BR"));
            parametros.put("SUBREPORT_DIR", "/home/gilmario/Projetos/NetBeansProjects/DocProject/web/WEB-INF/relatorios/");
            JRDataSource jrRS = new JRBeanCollectionDataSource(lista);
            JasperPrint print = JasperFillManager.fillReport(arquivo, parametros, jrRS);
            JasperViewer.viewReport(print, false);
            //JasperExportManager.exportReportToPdfFile(print, "/home/gilmario/manual.pdf");
        } catch (JRException ex) {
            Logger.getLogger(TestandoGeracaoManual.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
