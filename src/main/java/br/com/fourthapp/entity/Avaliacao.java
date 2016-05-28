package br.com.fourthapp.entity;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;

/**
 *
 * @author fernando
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Avaliacao.findByPublicacao", query = "select a from Avaliacao a where a.publicacao = :publicacao"),
    @NamedQuery(name = "Avaliacao.findByUsuario", query = "select a from Avaliacao a where a.usuario = :usuario"),
    @NamedQuery(name = "Avaliacao.findByTipo", query = "select a from Avaliacao a where a.tipoAvaliacao = :tipoAvaliacao")
})
public class Avaliacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Calendar dataAvaliacao;
    @Enumerated(EnumType.STRING)
    private TipoAvaliacao tipoAvaliacao;
    @ManyToOne
    private Usuario usuario;
    @ManyToOne
    private Publicacao publicacao;

    public Avaliacao() {
    }

    public Avaliacao(Calendar dataAvaliacao, TipoAvaliacao tipoAvaliacao, Usuario usuario, Publicacao publicacao) {
        this.dataAvaliacao = dataAvaliacao;
        this.tipoAvaliacao = tipoAvaliacao;
        this.usuario = usuario;
        this.publicacao = publicacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(Calendar dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public TipoAvaliacao getTipoAvaliacao() {
        return tipoAvaliacao;
    }

    public void setTipoAvaliacao(TipoAvaliacao tipoAvaliacao) {
        this.tipoAvaliacao = tipoAvaliacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Publicacao getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Publicacao publicacao) {
        this.publicacao = publicacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avaliacao)) {
            return false;
        }
        Avaliacao other = (Avaliacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fourthapp.entity.Avaliacao[ id=" + id + " ]";
    }

}
