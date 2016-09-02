/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serivicio;

import entities.SoTipoUsuario;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ihsa
 */
@javax.ejb.Stateless
public class SoTipoUsuarioFacade extends AbstractFacade<SoTipoUsuario> implements SoTipoUsuarioFacadeLocal {
    @PersistenceContext(unitName = "socialPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SoTipoUsuarioFacade() {
        super(SoTipoUsuario.class);
    }
    
}
