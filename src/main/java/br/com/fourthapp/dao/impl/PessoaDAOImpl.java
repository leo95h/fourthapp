package br.com.fourthapp.dao.impl;

import br.com.fourthapp.dao.AbstractDAO;
import br.com.fourthapp.dao.PessoaDAO;
import br.com.fourthapp.entity.Pessoa;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author fernando
 */
public class PessoaDAOImpl extends AbstractDAO<Pessoa> implements PessoaDAO {

    public PessoaDAOImpl() {
        super(Pessoa.class);
    }

    @Override
    public List<Pessoa> listarPessoasPorNome(String nome) {
        Query q = getEntityManager().createNamedQuery("Pessoa.findByNome", Pessoa.class);
        q.setParameter("nome", nome);
        return q.getResultList();
    }

    @Override
    public List<Pessoa> listarPessoasPorEmail(String email) {
        Query q = getEntityManager().createNamedQuery("Pessoa.findByEmail", Pessoa.class);
        q.setParameter("email", email);
        return q.getResultList();
    }

}
