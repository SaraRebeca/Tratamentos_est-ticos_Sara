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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Sara
 */
@Entity
@Table(name = "tratamento")
@NamedQueries({
    @NamedQuery(name = "Tratamento.findAll", query = "SELECT t FROM Tratamento t")})
public class Tratamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_tratamento")
    private Integer idTratamento;
    @Basic(optional = false)
    @Column(name = "nome_tratamento")
    private String nomeTratamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tratamento")
    private List<ClienteHasTratamento> clienteHasTratamentoList;
    @JoinColumn(name = "tipo_tratamento_id_tipo_tratamento", referencedColumnName = "id_tipo_tratamento")
    @ManyToOne(optional = false)
    private TipoTratamento tipoTratamentoIdTipoTratamento;

    public Tratamento() {
    }

    public Tratamento(Integer idTratamento) {
        this.idTratamento = idTratamento;
    }

    public Tratamento(Integer idTratamento, String nomeTratamento) {
        this.idTratamento = idTratamento;
        this.nomeTratamento = nomeTratamento;
    }

    public Integer getIdTratamento() {
        return idTratamento;
    }

    public void setIdTratamento(Integer idTratamento) {
        this.idTratamento = idTratamento;
    }

    public String getNomeTratamento() {
        return nomeTratamento;
    }

    public void setNomeTratamento(String nomeTratamento) {
        this.nomeTratamento = nomeTratamento;
    }

    public List<ClienteHasTratamento> getClienteHasTratamentoList() {
        return clienteHasTratamentoList;
    }

    public void setClienteHasTratamentoList(List<ClienteHasTratamento> clienteHasTratamentoList) {
        this.clienteHasTratamentoList = clienteHasTratamentoList;
    }

    public TipoTratamento getTipoTratamentoIdTipoTratamento() {
        return tipoTratamentoIdTipoTratamento;
    }

    public void setTipoTratamentoIdTipoTratamento(TipoTratamento tipoTratamentoIdTipoTratamento) {
        this.tipoTratamentoIdTipoTratamento = tipoTratamentoIdTipoTratamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTratamento != null ? idTratamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tratamento)) {
            return false;
        }
        Tratamento other = (Tratamento) object;
        if ((this.idTratamento == null && other.idTratamento != null) || (this.idTratamento != null && !this.idTratamento.equals(other.idTratamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Tratamento[ idTratamento=" + idTratamento + " ]";
    }
    
}
