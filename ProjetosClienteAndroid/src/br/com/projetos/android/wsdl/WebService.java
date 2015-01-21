/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android.wsdl;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author gilmario
 */
public class WebService {

    public StringBuilder executaRequisicao(String endereco, String xml) throws Exception {
        return enviaDadosSoap(endereco, xml);
    }

    // Envia o XML do Soap aos Servidores WSDL
    private StringBuilder enviaDadosSoap(String endereco, String xml) throws MalformedURLException, IOException {
        HttpURLConnection conexao = (HttpURLConnection) new URL(endereco).openConnection();
        conexao.setRequestMethod("POST");
        conexao.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
        conexao.setDoOutput(true);
        conexao.setChunkedStreamingMode(0);
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(conexao.getOutputStream())));
        w.append(xml);
        w.flush();
        w.close();
        BufferedReader br = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
        StringBuilder xmlResposta = new StringBuilder(br.readLine());
        while (br.ready()) {
            xmlResposta.append(br.readLine());
        }
        br.close();
        conexao.disconnect();
        return xmlResposta;
    }
}
