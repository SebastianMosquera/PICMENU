/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.picmenu.jpa.sessions;

import com.picmenu.jpa.entities.CalificacionesServicio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author adsi
 */
@Stateless
public class CalificacionesServicioFacade extends AbstractFacade<CalificacionesServicio> {
    @PersistenceContext(unitName = "PICMENU_PicMenu_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CalificacionesServicioFacade() {
        super(CalificacionesServicio.class);
    }
    
}
