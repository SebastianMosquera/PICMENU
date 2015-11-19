package com.picmenu.jpa.entities;

import com.picmenu.jpa.entities.CalificacionesServicio;
import com.picmenu.jpa.entities.Menus;
import com.picmenu.jpa.entities.Restaurantes;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-19T11:37:38")
@StaticMetamodel(Sedes.class)
public class Sedes_ { 

    public static volatile SingularAttribute<Sedes, Restaurantes> idRestaurantes;
    public static volatile SingularAttribute<Sedes, String> barrio;
    public static volatile ListAttribute<Sedes, CalificacionesServicio> calificacionesServicioList;
    public static volatile ListAttribute<Sedes, Menus> menusList;
    public static volatile SingularAttribute<Sedes, String> correo;
    public static volatile SingularAttribute<Sedes, String> direccion;
    public static volatile SingularAttribute<Sedes, Integer> idSede;
    public static volatile SingularAttribute<Sedes, String> telefono;
    public static volatile SingularAttribute<Sedes, String> nombre;

}