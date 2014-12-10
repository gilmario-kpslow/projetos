/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetos.android.service;

import android.util.Log;
import br.com.projeto.modelo.Responsavel;
import br.com.projetos.util.Mensagem;
import br.com.projetos.util.generic.TipoMensagem;
import java.io.IOException;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

/**
 *
 * @author gilmario
 */
public class ResponsavelService extends Service<Responsavel> {

    private static final String SERVICO = "Responsavel";

    public ResponsavelService() {

    }

    public Mensagem registrar(Responsavel responsavel) {
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        SoapObject request = new SoapObject("projetos", "registrarResponsavel");
        envelope.bodyOut = request;
        request.addPropertyIfValue("t", responsavel);
        HttpTransportSE transport = new HttpTransportSE("http://localhost:8080/projetos/reponsavel?wsdl");
        String resp = "";
        try {
            transport.call("projetos/" + "" + "registrarResponsavel", envelope);
            SoapPrimitive resultSOAP = (SoapPrimitive) ((SoapObject) envelope.bodyIn).getProperty(0);
            resp = resultSOAP.toString();
        } catch (IOException ex) {
            Log.i("TESTATNDO", ex.toString());
        } catch (XmlPullParserException ex) {
            Log.i("TESTATNDO", ex.toString());
        }
        return new Mensagem(TipoMensagem.ERRO, resp);
    }
}
