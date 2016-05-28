
package br.com.fourthapp.dao;

import br.com.fourthapp.entity.Publicacao;
import java.util.List;

/**
 *
 * @author Emerson Del Coli
 */
public interface PublicacaoDAO {
    public List<Publicacao> ListarNomePublicacao(String nome);
}
