package com.picmenu.jpa.entities;

import com.picmenu.jpa.entities.Menus;
import com.picmenu.jpa.entities.TipoProducto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-19T11:37:38")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile ListAttribute<Producto, TipoProducto> tipoProductoList;
    public static volatile SingularAttribute<Producto, String> ingredientes;
    public static volatile SingularAttribute<Producto, Double> precio;
    public static volatile SingularAttribute<Producto, Menus> idMenus;
    public static volatile SingularAttribute<Producto, Integer> idTIPOMENU;
    public static volatile SingularAttribute<Producto, Integer> cantidad;
    public static volatile SingularAttribute<Producto, String> bebidas;

}