package br.com.fourthapp.dao;

import br.com.fourthapp.entity.Pessoa;
import java.util.List;

/**
 *
 * @author fernando
 */
public interface PessoaDAO {

    public List<Pessoa> listarPessoasPorNome(String nome);

    public List<Pessoa> listarPessoasPorEmail(String email);
}
