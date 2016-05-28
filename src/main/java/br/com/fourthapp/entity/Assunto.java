package br.com.fourthapp.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author fernando
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Assunto.findByNome", query = "select a from Assunto a where a.nome = :nome"),
    @NamedQuery(name = "Assunto.findBySuperior", query = "select a from Assunto a where a.superior = :superior")
})
public class Assunto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @ManyToOne
    private Assunto superior;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "superior", orphanRemoval = true)
    private Set<Assunto> assuntos;

    public Assunto() {
        this.assuntos = new HashSet<>();
    }

    public Assunto(String nome) {
        this.nome = nome;
    }

    public Assunto(String nome, Assunto superior) {
        this.nome = nome;
        if (superior != null) {
            this.superior = superior;
            superior.getAssuntos().add(this);
        }
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

    public Assunto getSuperior() {
        return superior;
    }

    public void setSuperior(Assunto superior) {
        this.superior = superior;
    }

    public Set<Assunto> getAssuntos() {
        if(assuntos == null) {
            assuntos = new HashSet<>();
        }
        return assuntos;
    }

    public void setAssuntos(Set<Assunto> assuntos) {
        this.assuntos = assuntos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.nome);
        hash = 41 * hash + Objects.hashCode(this.superior);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Assunto other = (Assunto) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.superior, other.superior)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return nome;
    }

}
