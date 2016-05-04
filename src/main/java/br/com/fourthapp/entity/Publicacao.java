package br.com.fourthapp.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author fernando
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Publicacao.findByNome", query = "select p from Publicacao p where p.nome = :nome")
})

public class Publicacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Calendar dataPublicacao;
    private String texto;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "arquivo_publicacao", joinColumns = {
        @JoinColumn(name = "publicacao_id")}, inverseJoinColumns = {
        @JoinColumn(name = "arquivo_id")})
    private Set<Arquivo> arquivos;
    @OneToMany(mappedBy = "publicacao", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Avaliacao> avaliacoes;
    @OneToMany(mappedBy = "publicacao", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comentario> comentarios;

    public Publicacao() {
    }

    public Publicacao(String nome, Calendar dataPublicacao, String texto, Set<Arquivo> arquivos, Set<Avaliacao> avaliacoes, Set<Comentario> comentarios) {
        this.nome = nome;
        this.dataPublicacao = dataPublicacao;
        this.texto = texto;
        this.arquivos = arquivos;
        this.avaliacoes = avaliacoes;
        this.comentarios = comentarios;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Calendar dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Set<Arquivo> getArquivos() {
        return arquivos;
    }

    public void setArquivos(Set<Arquivo> arquivos) {
        this.arquivos = arquivos;
    }

    public Set<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(Set<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public Set<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(Set<Comentario> comentarios) {
        this.comentarios = comentarios;
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
        if (!(object instanceof Publicacao)) {
            return false;
        }
        Publicacao other = (Publicacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fourthapp.entity.Publicacao[ id=" + id + " ]";
    }

}
