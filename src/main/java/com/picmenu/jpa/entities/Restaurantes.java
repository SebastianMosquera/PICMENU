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
@Table(name = "RESTAURANTES")
@NamedQueries({
    @NamedQuery(name = "Restaurantes.findAll", query = "SELECT r FROM Restaurantes r")})
public class Restaurantes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_Restaurantes")
    private Integer idRestaurantes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "correo")
    private String correo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRestaurantes")
    private List<Sedes> sedesList;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuarios idUsuario;

    public Restaurantes() {
    }

    public Restaurantes(Integer idRestaurantes) {
        this.idRestaurantes = idRestaurantes;
    }

    public Restaurantes(Integer idRestaurantes, String nombre, String telefono, String correo) {
        this.idRestaurantes = idRestaurantes;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Integer getIdRestaurantes() {
        return idRestaurantes;
    }

    public void setIdRestaurantes(Integer idRestaurantes) {
        this.idRestaurantes = idRestaurantes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Sedes> getSedesList() {
        return sedesList;
    }

    public void setSedesList(List<Sedes> sedesList) {
        this.sedesList = sedesList;
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
        hash += (idRestaurantes != null ? idRestaurantes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Restaurantes)) {
            return false;
        }
        Restaurantes other = (Restaurantes) object;
        if ((this.idRestaurantes == null && other.idRestaurantes != null) || (this.idRestaurantes != null && !this.idRestaurantes.equals(other.idRestaurantes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.picmenu.jpa.entities.Restaurantes[ idRestaurantes=" + idRestaurantes + " ]";
    }
    
}
