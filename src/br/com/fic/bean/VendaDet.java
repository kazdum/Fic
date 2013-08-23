/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fic.bean;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author i3
 */
@Entity
@Table(name = "venda_det", catalog = "fic_java", schema = "")
@NamedQueries({
    @NamedQuery(name = "VendaDet.findAll", query = "SELECT v FROM VendaDet v"),
    @NamedQuery(name = "VendaDet.findByCodVendaCab", query = "SELECT v FROM VendaDet v WHERE v.vendaDetPK.codVendaCab = :codVendaCab"),
    @NamedQuery(name = "VendaDet.findByCodProduto", query = "SELECT v FROM VendaDet v WHERE v.vendaDetPK.codProduto = :codProduto"),
    @NamedQuery(name = "VendaDet.findByQtdVendaDet", query = "SELECT v FROM VendaDet v WHERE v.qtdVendaDet = :qtdVendaDet"),
    @NamedQuery(name = "VendaDet.findByVlrUnitVendaDet", query = "SELECT v FROM VendaDet v WHERE v.vlrUnitVendaDet = :vlrUnitVendaDet"),
    @NamedQuery(name = "VendaDet.findByVlrTotalVendaDet", query = "SELECT v FROM VendaDet v WHERE v.vlrTotalVendaDet = :vlrTotalVendaDet")})
public class VendaDet implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VendaDetPK vendaDetPK;
    @Column(name = "QTD_VENDA_DET")
    private Integer qtdVendaDet;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VLR_UNIT_VENDA_DET")
    private Double vlrUnitVendaDet;
    @Column(name = "VLR_TOTAL_VENDA_DET")
    private Double vlrTotalVendaDet;
    @JoinColumn(name = "COD_VENDA_CAB", referencedColumnName = "COD_VENDA_CAB", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private VendaCab vendaCab;
    @Transient
    private String descricaoProduto;
    
    public void setDescricaoProduto(String desc){
        this.descricaoProduto = desc;
    }

    public String getDescricaoProduto(){
        return descricaoProduto;
    }
    public VendaDet() {
    }

    public VendaDet(VendaDetPK vendaDetPK) {
        this.vendaDetPK = vendaDetPK;
    }

    public VendaDet(int codVendaCab, String codProduto) {
        this.vendaDetPK = new VendaDetPK(codVendaCab, codProduto);
    }

    public VendaDetPK getVendaDetPK() {
        return vendaDetPK;
    }

    public void setVendaDetPK(VendaDetPK vendaDetPK) {
        this.vendaDetPK = vendaDetPK;
    }

    public Integer getQtdVendaDet() {
        return qtdVendaDet;
    }

    public void setQtdVendaDet(Integer qtdVendaDet) {
        Integer oldQtdVendaDet = this.qtdVendaDet;
        this.qtdVendaDet = qtdVendaDet;
        changeSupport.firePropertyChange("qtdVendaDet", oldQtdVendaDet, qtdVendaDet);
    }

    public Double getVlrUnitVendaDet() {
        return vlrUnitVendaDet;
    }

    public void setVlrUnitVendaDet(Double vlrUnitVendaDet) {
        Double oldVlrUnitVendaDet = this.vlrUnitVendaDet;
        this.vlrUnitVendaDet = vlrUnitVendaDet;
        changeSupport.firePropertyChange("vlrUnitVendaDet", oldVlrUnitVendaDet, vlrUnitVendaDet);
    }

    public Double getVlrTotalVendaDet() {
        return vlrTotalVendaDet;
    }

    public void setVlrTotalVendaDet(Double vlrTotalVendaDet) {
        Double oldVlrTotalVendaDet = this.vlrTotalVendaDet;
        this.vlrTotalVendaDet = vlrTotalVendaDet;
        changeSupport.firePropertyChange("vlrTotalVendaDet", oldVlrTotalVendaDet, vlrTotalVendaDet);
    }

    public VendaCab getVendaCab() {
        return vendaCab;
    }

    public void setVendaCab(VendaCab vendaCab) {
        VendaCab oldVendaCab = this.vendaCab;
        this.vendaCab = vendaCab;
        changeSupport.firePropertyChange("vendaCab", oldVendaCab, vendaCab);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vendaDetPK != null ? vendaDetPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VendaDet)) {
            return false;
        }
        VendaDet other = (VendaDet) object;
        if ((this.vendaDetPK == null && other.vendaDetPK != null) || (this.vendaDetPK != null && !this.vendaDetPK.equals(other.vendaDetPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fic.bean.VendaDet[ vendaDetPK=" + vendaDetPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
