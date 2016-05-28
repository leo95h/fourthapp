package br.com.fourthapp.entity.fixture;

import br.com.fourthapp.entity.Avaliacao;
import br.com.fourthapp.entity.Publicacao;
import br.com.fourthapp.entity.TipoAvaliacao;
import br.com.fourthapp.entity.Usuario;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author fernando
 */
public class AvaliacaoFixture {

    public static Avaliacao newAvaliacao(TipoAvaliacao tipoAvaliacao, Usuario usuario, Publicacao publicacao) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        return newAvaliacao(c, tipoAvaliacao, usuario, publicacao);
    }

    private static Avaliacao newAvaliacao(Calendar dataAvaliacao, TipoAvaliacao tipoAvaliacao, Usuario usuario, Publicacao publicacao) {
        return new Avaliacao(dataAvaliacao, tipoAvaliacao, usuario, publicacao);
    }
}
