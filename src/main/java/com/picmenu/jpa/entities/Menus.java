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
@Table(name = "MENUS")
@NamedQueries({
    @NamedQuery(name = "Menus.findAll", query = "SELECT m FROM Menus m")})
public class Menus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_Menus")
    private Integer idMenus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_menu")
    private String nombreMenu;
    @JoinColumn(name = "SEDES_id_sede", referencedColumnName = "id_sede")
    @ManyToOne(optional = false)
    private Sedes sEDESidsede;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMenus")
    private List<Producto> productoList;

    public Menus() {
    }

    public Menus(Integer idMenus) {
        this.idMenus = idMenus;
    }

    public Menus(Integer idMenus, String nombreMenu) {
        this.idMenus = idMenus;
        this.nombreMenu = nombreMenu;
    }

    public Integer getIdMenus() {
        return idMenus;
    }

    public void setIdMenus(Integer idMenus) {
        this.idMenus = idMenus;
    }

    public String getNombreMenu() {
        return nombreMenu;
    }

    public void setNombreMenu(String nombreMenu) {
        this.nombreMenu = nombreMenu;
    }

    public Sedes getSEDESidsede() {
        return sEDESidsede;
    }

    public void setSEDESidsede(Sedes sEDESidsede) {
        this.sEDESidsede = sEDESidsede;
    }

    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMenus != null ? idMenus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menus)) {
            return false;
        }
        Menus other = (Menus) object;
        if ((this.idMenus == null && other.idMenus != null) || (this.idMenus != null && !this.idMenus.equals(other.idMenus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.picmenu.jpa.entities.Menus[ idMenus=" + idMenus + " ]";
    }
    
}
