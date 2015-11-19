package com.picmenu.jpa.entities;

import com.picmenu.jpa.entities.Pedidos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-19T11:37:38")
@StaticMetamodel(TipoPedido.class)
public class TipoPedido_ { 

    public static volatile SingularAttribute<TipoPedido, Date> fechaPedidoCancelacion;
    public static volatile SingularAttribute<TipoPedido, String> clientePedido;
    public static volatile SingularAttribute<TipoPedido, Date> fechaPedido;
    public static volatile SingularAttribute<TipoPedido, Date> horaPedidoCancelacion;
    public static volatile SingularAttribute<TipoPedido, Pedidos> idPEDIDOS;
    public static volatile SingularAttribute<TipoPedido, Integer> idTIPOPEDIDO;
    public static volatile SingularAttribute<TipoPedido, Date> horaPedido;

}