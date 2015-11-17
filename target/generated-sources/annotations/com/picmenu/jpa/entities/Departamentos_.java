package com.picmenu.jpa.entities;

import com.picmenu.jpa.entities.Ciudades;
import com.picmenu.jpa.entities.Paises;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-17T07:51:06")
@StaticMetamodel(Departamentos.class)
public class Departamentos_ { 

    public static volatile SingularAttribute<Departamentos, Integer> idDepartamento;
    public static volatile SingularAttribute<Departamentos, String> nombreDepartamento;
    public static volatile SingularAttribute<Departamentos, Paises> idPais;
    public static volatile ListAttribute<Departamentos, Ciudades> ciudadesList;

}