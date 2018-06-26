/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Sara
 */
@Entity
@Table(name = "tipo_tratamento")
@NamedQueries({
    @NamedQuery(name = "TipoTratamento.findAll", query = "SELECT t FROM TipoTratamento t")})
public class TipoTratamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_tipo_tratamento")
    private Integer idTipoTratamento;
    @Basic(optional = false)
    @Column(name = "nome_tipo_tratamentocol")
    private String nomeTipoTratamentocol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoTratamentoIdTipoTratamento")
    private List<Tratamento> tratamentoList;

    public TipoTratamento() {
    }

    public TipoTratamento(Integer idTipoTratamento) {
        this.idTipoTratamento = idTipoTratamento;
    }

    public TipoTratamento(Integer idTipoTratamento, String nomeTipoTratamentocol) {
        this.idTipoTratamento = idTipoTratamento;
        this.nomeTipoTratamentocol = nomeTipoTratamentocol;
    }

    public Integer getIdTipoTratamento() {
        return idTipoTratamento;
    }

    public void setIdTipoTratamento(Integer idTipoTratamento) {
        this.idTipoTratamento = idTipoTratamento;
    }

    public String getNomeTipoTratamentocol() {
        return nomeTipoTratamentocol;
    }

    public void setNomeTipoTratamentocol(String nomeTipoTratamentocol) {
        this.nomeTipoTratamentocol = nomeTipoTratamentocol;
    }

    public List<Tratamento> getTratamentoList() {
        return tratamentoList;
    }

    public void setTratamentoList(List<Tratamento> tratamentoList) {
        this.tratamentoList = tratamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoTratamento != null ? idTipoTratamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoTratamento)) {
            return false;
        }
        TipoTratamento other = (TipoTratamento) object;
        if ((this.idTipoTratamento == null && other.idTipoTratamento != null) || (this.idTipoTratamento != null && !this.idTipoTratamento.equals(other.idTipoTratamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.TipoTratamento[ idTipoTratamento=" + idTipoTratamento + " ]";
    }
    
}
