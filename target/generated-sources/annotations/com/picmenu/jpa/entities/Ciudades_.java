package com.picmenu.jpa.entities;

import com.picmenu.jpa.entities.CiudadesPK;
import com.picmenu.jpa.entities.Departamentos;
import com.picmenu.jpa.entities.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-17T07:51:06")
@StaticMetamodel(Ciudades.class)
public class Ciudades_ { 

    public static volatile ListAttribute<Ciudades, Usuarios> usuariosList;
    public static volatile SingularAttribute<Ciudades, String> nombreCiudad;
    public static volatile SingularAttribute<Ciudades, CiudadesPK> ciudadesPK;
    public static volatile SingularAttribute<Ciudades, Departamentos> departamentos;

}