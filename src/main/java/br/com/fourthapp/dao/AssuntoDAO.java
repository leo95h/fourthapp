/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fourthapp.dao;

import br.com.fourthapp.entity.Assunto;
import java.util.List;

/**
 *
 * @author fernando
 */
public interface AssuntoDAO {

    public Assunto buscarAssuntoPorNome(String nome);

    public List<Assunto> buscarAssuntosFilhos(Assunto assunto);

}
