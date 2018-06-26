/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Sara
 */
@Embeddable
public class ClienteHasTratamentoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "cliente_id_cliente")
    private int clienteIdCliente;
    @Basic(optional = false)
    @Column(name = "tratamento_id_tratamento")
    private int tratamentoIdTratamento;

    public ClienteHasTratamentoPK() {
    }

    public ClienteHasTratamentoPK(int clienteIdCliente, int tratamentoIdTratamento) {
        this.clienteIdCliente = clienteIdCliente;
        this.tratamentoIdTratamento = tratamentoIdTratamento;
    }

    public int getClienteIdCliente() {
        return clienteIdCliente;
    }

    public void setClienteIdCliente(int clienteIdCliente) {
        this.clienteIdCliente = clienteIdCliente;
    }

    public int getTratamentoIdTratamento() {
        return tratamentoIdTratamento;
    }

    public void setTratamentoIdTratamento(int tratamentoIdTratamento) {
        this.tratamentoIdTratamento = tratamentoIdTratamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) clienteIdCliente;
        hash += (int) tratamentoIdTratamento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteHasTratamentoPK)) {
            return false;
        }
        ClienteHasTratamentoPK other = (ClienteHasTratamentoPK) object;
        if (this.clienteIdCliente != other.clienteIdCliente) {
            return false;
        }
        if (this.tratamentoIdTratamento != other.tratamentoIdTratamento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.ClienteHasTratamentoPK[ clienteIdCliente=" + clienteIdCliente + ", tratamentoIdTratamento=" + tratamentoIdTratamento + " ]";
    }
    
}
