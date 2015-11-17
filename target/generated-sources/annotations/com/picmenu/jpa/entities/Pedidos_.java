package com.picmenu.jpa.entities;

import com.picmenu.jpa.entities.TipoPedido;
import com.picmenu.jpa.entities.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-17T07:51:06")
@StaticMetamodel(Pedidos.class)
public class Pedidos_ { 

    public static volatile SingularAttribute<Pedidos, Usuarios> idUsuario;
    public static volatile SingularAttribute<Pedidos, Integer> idPEDIDOS;
    public static volatile SingularAttribute<Pedidos, String> nombrePedido;
    public static volatile ListAttribute<Pedidos, TipoPedido> tipoPedidoList;

}