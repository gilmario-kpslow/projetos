/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.managedBean;

import br.com.projeto.modelo.Responsavel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author gilmario
 */
@Named
@RequestScoped
public class UsuarioBean implements Serializable {

    public List<Responsavel> getResponsaveis() {

        return new ArrayList<>();
    }

}
