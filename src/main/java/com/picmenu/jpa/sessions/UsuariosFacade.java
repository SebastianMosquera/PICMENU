/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.picmenu.jpa.sessions;

import com.picmenu.jpa.entities.Usuarios;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author adsi
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> {
    @PersistenceContext(unitName = "PICMENU_PicMenu_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
    public Usuarios findByCorreoElectronico (String correoelectronico){
        try{
            return (Usuarios) entityManager.createNamedQuery("Usuarios.findByCorreoElectronico")
                    .setParameter("correoelectronico", correoelectronico)
                    .getSingleResult();
            
        }catch(NonUniqueResultException ex){
            throw ex;
        }catch(NoResultException ex){
            return null;
        }
    }
    
}
