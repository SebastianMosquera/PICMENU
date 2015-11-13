/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.picmenu.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author adsi
 */
@Entity
@Table(name = "TIPO_PEDIDO")
@NamedQueries({
    @NamedQuery(name = "TipoPedido.findAll", query = "SELECT t FROM TipoPedido t")})
public class TipoPedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_TIPO_PEDIDO")
    private Integer idTIPOPEDIDO;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cliente_pedido")
    private String clientePedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_pedido")
    @Temporal(TemporalType.DATE)
    private Date fechaPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_pedido")
    @Temporal(TemporalType.TIME)
    private Date horaPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_pedido_cancelacion")
    @Temporal(TemporalType.DATE)
    private Date fechaPedidoCancelacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_pedido_cancelacion")
    @Temporal(TemporalType.TIME)
    private Date horaPedidoCancelacion;
    @JoinColumn(name = "id_PEDIDOS", referencedColumnName = "id_PEDIDOS")
    @ManyToOne(optional = false)
    private Pedidos idPEDIDOS;

    public TipoPedido() {
    }

    public TipoPedido(Integer idTIPOPEDIDO) {
        this.idTIPOPEDIDO = idTIPOPEDIDO;
    }

    public TipoPedido(Integer idTIPOPEDIDO, String clientePedido, Date fechaPedido, Date horaPedido, Date fechaPedidoCancelacion, Date horaPedidoCancelacion) {
        this.idTIPOPEDIDO = idTIPOPEDIDO;
        this.clientePedido = clientePedido;
        this.fechaPedido = fechaPedido;
        this.horaPedido = horaPedido;
        this.fechaPedidoCancelacion = fechaPedidoCancelacion;
        this.horaPedidoCancelacion = horaPedidoCancelacion;
    }

    public Integer getIdTIPOPEDIDO() {
        return idTIPOPEDIDO;
    }

    public void setIdTIPOPEDIDO(Integer idTIPOPEDIDO) {
        this.idTIPOPEDIDO = idTIPOPEDIDO;
    }

    public String getClientePedido() {
        return clientePedido;
    }

    public void setClientePedido(String clientePedido) {
        this.clientePedido = clientePedido;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Date getHoraPedido() {
        return horaPedido;
    }

    public void setHoraPedido(Date horaPedido) {
        this.horaPedido = horaPedido;
    }

    public Date getFechaPedidoCancelacion() {
        return fechaPedidoCancelacion;
    }

    public void setFechaPedidoCancelacion(Date fechaPedidoCancelacion) {
        this.fechaPedidoCancelacion = fechaPedidoCancelacion;
    }

    public Date getHoraPedidoCancelacion() {
        return horaPedidoCancelacion;
    }

    public void setHoraPedidoCancelacion(Date horaPedidoCancelacion) {
        this.horaPedidoCancelacion = horaPedidoCancelacion;
    }

    public Pedidos getIdPEDIDOS() {
        return idPEDIDOS;
    }

    public void setIdPEDIDOS(Pedidos idPEDIDOS) {
        this.idPEDIDOS = idPEDIDOS;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTIPOPEDIDO != null ? idTIPOPEDIDO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPedido)) {
            return false;
        }
        TipoPedido other = (TipoPedido) object;
        if ((this.idTIPOPEDIDO == null && other.idTIPOPEDIDO != null) || (this.idTIPOPEDIDO != null && !this.idTIPOPEDIDO.equals(other.idTIPOPEDIDO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.picmenu.jpa.entities.TipoPedido[ idTIPOPEDIDO=" + idTIPOPEDIDO + " ]";
    }
    
}
