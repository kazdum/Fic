/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fic.bean;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author i3
 */
@Entity
@Table(name = "base_cep", catalog = "fic_java", schema = "")
@NamedQueries({
    @NamedQuery(name = "CorreiosCeps.findAll", query = "SELECT c FROM CorreiosCeps c"),
    @NamedQuery(name = "CorreiosCeps.findById", query = "SELECT c FROM CorreiosCeps c WHERE c.id = :id"),
    @NamedQuery(name = "CorreiosCeps.findByCep", query = "SELECT c FROM CorreiosCeps c WHERE c.cep = :cep"),
    @NamedQuery(name = "CorreiosCeps.findByLogradouro", query = "SELECT c FROM CorreiosCeps c WHERE c.logradouro = :logradouro"),
    @NamedQuery(name = "CorreiosCeps.findByBairro", query = "SELECT c FROM CorreiosCeps c WHERE c.bairro = :bairro"),
    @NamedQuery(name = "CorreiosCeps.findByCidade", query = "SELECT c FROM CorreiosCeps c WHERE c.cidade = :cidade"),
    @NamedQuery(name = "CorreiosCeps.findByEstado", query = "SELECT c FROM CorreiosCeps c WHERE c.estado = :estado")})
public class CorreiosCeps implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "cep")
    private int cep;
    @Basic(optional = false)
    @Column(name = "logradouro")
    private String logradouro;
    @Basic(optional = false)
    @Column(name = "bairro")
    private String bairro;
    @Basic(optional = false)
    @Column(name = "cidade")
    private String cidade;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;

    public CorreiosCeps() {
    }

    public CorreiosCeps(Integer id) {
        this.id = id;
    }

    public CorreiosCeps(Integer id, int cep, String logradouro, String bairro, String cidade, String estado) {
        this.id = id;
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        int oldCep = this.cep;
        this.cep = cep;
        changeSupport.firePropertyChange("cep", oldCep, cep);
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        String oldLogradouro = this.logradouro;
        this.logradouro = logradouro;
        changeSupport.firePropertyChange("logradouro", oldLogradouro, logradouro);
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        String oldBairro = this.bairro;
        this.bairro = bairro;
        changeSupport.firePropertyChange("bairro", oldBairro, bairro);
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        String oldCidade = this.cidade;
        this.cidade = cidade;
        changeSupport.firePropertyChange("cidade", oldCidade, cidade);
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        String oldEstado = this.estado;
        this.estado = estado;
        changeSupport.firePropertyChange("estado", oldEstado, estado);
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
        if (!(object instanceof CorreiosCeps)) {
            return false;
        }
        CorreiosCeps other = (CorreiosCeps) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fic.bean.CorreiosCeps[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
