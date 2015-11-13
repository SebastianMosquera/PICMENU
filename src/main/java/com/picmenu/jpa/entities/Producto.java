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
@Table(name = "PRODUCTO")
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")})
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_TIPO_MENU")
    private Integer idTIPOMENU;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ingredientes")
    private String ingredientes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private double precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "bebidas")
    private String bebidas;
    @JoinColumn(name = "id_Menus", referencedColumnName = "id_Menus")
    @ManyToOne(optional = false)
    private Menus idMenus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pRODUCTOidTIPOMENU")
    private List<TipoProducto> tipoProductoList;

    public Producto() {
    }

    public Producto(Integer idTIPOMENU) {
        this.idTIPOMENU = idTIPOMENU;
    }

    public Producto(Integer idTIPOMENU, String ingredientes, double precio, int cantidad, String bebidas) {
        this.idTIPOMENU = idTIPOMENU;
        this.ingredientes = ingredientes;
        this.precio = precio;
        this.cantidad = cantidad;
        this.bebidas = bebidas;
    }

    public Integer getIdTIPOMENU() {
        return idTIPOMENU;
    }

    public void setIdTIPOMENU(Integer idTIPOMENU) {
        this.idTIPOMENU = idTIPOMENU;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getBebidas() {
        return bebidas;
    }

    public void setBebidas(String bebidas) {
        this.bebidas = bebidas;
    }

    public Menus getIdMenus() {
        return idMenus;
    }

    public void setIdMenus(Menus idMenus) {
        this.idMenus = idMenus;
    }

    public List<TipoProducto> getTipoProductoList() {
        return tipoProductoList;
    }

    public void setTipoProductoList(List<TipoProducto> tipoProductoList) {
        this.tipoProductoList = tipoProductoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTIPOMENU != null ? idTIPOMENU.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idTIPOMENU == null && other.idTIPOMENU != null) || (this.idTIPOMENU != null && !this.idTIPOMENU.equals(other.idTIPOMENU))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.picmenu.jpa.entities.Producto[ idTIPOMENU=" + idTIPOMENU + " ]";
    }
    
}
