package br.com.fourthapp.dao;

import br.com.fourthapp.entity.Grupo;

/**
 *
 * @author fernando
 */
public interface GrupoDAO {
    
    public Grupo buscarGrupoPorNome(String nome);
    
}
