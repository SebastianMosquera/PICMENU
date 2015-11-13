/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.picmenu.jpa.entities;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author adsi
 */
@Entity
@Table(name = "PEDIDOS")
@NamedQueries({
    @NamedQuery(name = "Pedidos.findAll", query = "SELECT p FROM Pedidos p")})
public class Pedidos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_PEDIDOS")
    private Integer idPEDIDOS;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_pedido")
    private String nombrePedido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPEDIDOS")
    private List<TipoPedido> tipoPedidoList;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuarios idUsuario;

    public Pedidos() {
    }

    public Pedidos(Integer idPEDIDOS) {
        this.idPEDIDOS = idPEDIDOS;
    }

    public Pedidos(Integer idPEDIDOS, String nombrePedido) {
        this.idPEDIDOS = idPEDIDOS;
        this.nombrePedido = nombrePedido;
    }

    public Integer getIdPEDIDOS() {
        return idPEDIDOS;
    }

    public void setIdPEDIDOS(Integer idPEDIDOS) {
        this.idPEDIDOS = idPEDIDOS;
    }

    public String getNombrePedido() {
        return nombrePedido;
    }

    public void setNombrePedido(String nombrePedido) {
        this.nombrePedido = nombrePedido;
    }

    public List<TipoPedido> getTipoPedidoList() {
        return tipoPedidoList;
    }

    public void setTipoPedidoList(List<TipoPedido> tipoPedidoList) {
        this.tipoPedidoList = tipoPedidoList;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPEDIDOS != null ? idPEDIDOS.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedidos)) {
            return false;
        }
        Pedidos other = (Pedidos) object;
        if ((this.idPEDIDOS == null && other.idPEDIDOS != null) || (this.idPEDIDOS != null && !this.idPEDIDOS.equals(other.idPEDIDOS))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.picmenu.jpa.entities.Pedidos[ idPEDIDOS=" + idPEDIDOS + " ]";
    }
    
}
