/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Sara
 */
@Entity
@Table(name = "cliente_has_tratamento")
@NamedQueries({
    @NamedQuery(name = "ClienteHasTratamento.findAll", query = "SELECT c FROM ClienteHasTratamento c")})
public class ClienteHasTratamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClienteHasTratamentoPK clienteHasTratamentoPK;
    @Basic(optional = false)
    @Column(name = "valor")
    private double valor;
    @Basic(optional = false)
    @Column(name = "data_horario_agendamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHorarioAgendamento;
    @JoinColumn(name = "cliente_id_cliente", referencedColumnName = "id_cliente", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;
    @JoinColumn(name = "tratamento_id_tratamento", referencedColumnName = "id_tratamento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tratamento tratamento;

    public ClienteHasTratamento() {
    }

    public ClienteHasTratamento(ClienteHasTratamentoPK clienteHasTratamentoPK) {
        this.clienteHasTratamentoPK = clienteHasTratamentoPK;
    }

    public ClienteHasTratamento(ClienteHasTratamentoPK clienteHasTratamentoPK, double valor, Date dataHorarioAgendamento) {
        this.clienteHasTratamentoPK = clienteHasTratamentoPK;
        this.valor = valor;
        this.dataHorarioAgendamento = dataHorarioAgendamento;
    }

    public ClienteHasTratamento(int clienteIdCliente, int tratamentoIdTratamento) {
        this.clienteHasTratamentoPK = new ClienteHasTratamentoPK(clienteIdCliente, tratamentoIdTratamento);
    }

    public ClienteHasTratamentoPK getClienteHasTratamentoPK() {
        return clienteHasTratamentoPK;
    }

    public void setClienteHasTratamentoPK(ClienteHasTratamentoPK clienteHasTratamentoPK) {
        this.clienteHasTratamentoPK = clienteHasTratamentoPK;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataHorarioAgendamento() {
        return dataHorarioAgendamento;
    }

    public void setDataHorarioAgendamento(Date dataHorarioAgendamento) {
        this.dataHorarioAgendamento = dataHorarioAgendamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Tratamento getTratamento() {
        return tratamento;
    }

    public void setTratamento(Tratamento tratamento) {
        this.tratamento = tratamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clienteHasTratamentoPK != null ? clienteHasTratamentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteHasTratamento)) {
            return false;
        }
        ClienteHasTratamento other = (ClienteHasTratamento) object;
        if ((this.clienteHasTratamentoPK == null && other.clienteHasTratamentoPK != null) || (this.clienteHasTratamentoPK != null && !this.clienteHasTratamentoPK.equals(other.clienteHasTratamentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ClienteHasTratamento[ clienteHasTratamentoPK=" + clienteHasTratamentoPK + " ]";
    }
    
}
