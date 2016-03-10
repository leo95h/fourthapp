package br.com.fourthapp.dao;

import br.com.fourthapp.entity.Pessoa;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author fernando
 */
public class PessoaDAO extends AbstractDAO<Pessoa> {

    public PessoaDAO() {
        super(Pessoa.class);
    }

    public List<Pessoa> listPessoasByNome(String nome) {
        Query q = getEntityManager().createNamedQuery("pessoas.findByNome", Pessoa.class);
        q.setParameter("nome", nome);
        return q.getResultList();
    }

}
