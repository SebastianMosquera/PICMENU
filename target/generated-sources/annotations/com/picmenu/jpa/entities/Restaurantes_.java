package com.picmenu.jpa.entities;

import com.picmenu.jpa.entities.Sedes;
import com.picmenu.jpa.entities.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-19T11:37:38")
@StaticMetamodel(Restaurantes.class)
public class Restaurantes_ { 

    public static volatile SingularAttribute<Restaurantes, Integer> idRestaurantes;
    public static volatile SingularAttribute<Restaurantes, String> correo;
    public static volatile SingularAttribute<Restaurantes, Usuarios> idUsuario;
    public static volatile ListAttribute<Restaurantes, Sedes> sedesList;
    public static volatile SingularAttribute<Restaurantes, String> telefono;
    public static volatile SingularAttribute<Restaurantes, String> nombre;

}