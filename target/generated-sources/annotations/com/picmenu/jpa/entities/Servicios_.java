package com.picmenu.jpa.entities;

import com.picmenu.jpa.entities.CalificacionesServicio;
import com.picmenu.jpa.entities.TiposServicio;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-17T07:51:06")
@StaticMetamodel(Servicios.class)
public class Servicios_ { 

    public static volatile SingularAttribute<Servicios, String> descripcion;
    public static volatile SingularAttribute<Servicios, CalificacionesServicio> calificacionesServicio;
    public static volatile SingularAttribute<Servicios, Double> valor;
    public static volatile SingularAttribute<Servicios, Integer> idServicio;
    public static volatile SingularAttribute<Servicios, String> nombre;
    public static volatile SingularAttribute<Servicios, TiposServicio> idTipoServicio;

}