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
import javax.persistence.OneToOne;
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
@Table(name = "CALIFICACIONES_SERVICIO")
@NamedQueries({
    @NamedQuery(name = "CalificacionesServicio.findAll", query = "SELECT c FROM CalificacionesServicio c")})
public class CalificacionesServicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_servicio")
    private Integer idServicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puntuacion")
    private short puntuacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 140)
    @Column(name = "comentario")
    private String comentario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "SEDES_id_sede", referencedColumnName = "id_sede")
    @ManyToOne(optional = false)
    private Sedes sEDESidsede;
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Servicios servicios;

    public CalificacionesServicio() {
    }

    public CalificacionesServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public CalificacionesServicio(Integer idServicio, short puntuacion, String comentario, Date fecha) {
        this.idServicio = idServicio;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
        this.fecha = fecha;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public short getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(short puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Sedes getSEDESidsede() {
        return sEDESidsede;
    }

    public void setSEDESidsede(Sedes sEDESidsede) {
        this.sEDESidsede = sEDESidsede;
    }

    public Servicios getServicios() {
        return servicios;
    }

    public void setServicios(Servicios servicios) {
        this.servicios = servicios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServicio != null ? idServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CalificacionesServicio)) {
            return false;
        }
        CalificacionesServicio other = (CalificacionesServicio) object;
        if ((this.idServicio == null && other.idServicio != null) || (this.idServicio != null && !this.idServicio.equals(other.idServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.picmenu.jpa.entities.CalificacionesServicio[ idServicio=" + idServicio + " ]";
    }
    
}
