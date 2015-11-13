/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.picmenu.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author adsi
 */
@Entity
@Table(name = "TIPO_PRODUCTO")
@NamedQueries({
    @NamedQuery(name = "TipoProducto.findAll", query = "SELECT t FROM TipoProducto t")})
public class TipoProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_TIPO_PRODUCTO")
    private Integer idTIPOPRODUCTO;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "comidas")
    private String comidas;
    @JoinColumn(name = "PRODUCTO_id_TIPO_MENU", referencedColumnName = "id_TIPO_MENU")
    @ManyToOne(optional = false)
    private Producto pRODUCTOidTIPOMENU;

    public TipoProducto() {
    }

    public TipoProducto(Integer idTIPOPRODUCTO) {
        this.idTIPOPRODUCTO = idTIPOPRODUCTO;
    }

    public TipoProducto(Integer idTIPOPRODUCTO, String nombre, String comidas) {
        this.idTIPOPRODUCTO = idTIPOPRODUCTO;
        this.nombre = nombre;
        this.comidas = comidas;
    }

    public Integer getIdTIPOPRODUCTO() {
        return idTIPOPRODUCTO;
    }

    public void setIdTIPOPRODUCTO(Integer idTIPOPRODUCTO) {
        this.idTIPOPRODUCTO = idTIPOPRODUCTO;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComidas() {
        return comidas;
    }

    public void setComidas(String comidas) {
        this.comidas = comidas;
    }

    public Producto getPRODUCTOidTIPOMENU() {
        return pRODUCTOidTIPOMENU;
    }

    public void setPRODUCTOidTIPOMENU(Producto pRODUCTOidTIPOMENU) {
        this.pRODUCTOidTIPOMENU = pRODUCTOidTIPOMENU;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTIPOPRODUCTO != null ? idTIPOPRODUCTO.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoProducto)) {
            return false;
        }
        TipoProducto other = (TipoProducto) object;
        if ((this.idTIPOPRODUCTO == null && other.idTIPOPRODUCTO != null) || (this.idTIPOPRODUCTO != null && !this.idTIPOPRODUCTO.equals(other.idTIPOPRODUCTO))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.picmenu.jpa.entities.TipoProducto[ idTIPOPRODUCTO=" + idTIPOPRODUCTO + " ]";
    }
    
}
