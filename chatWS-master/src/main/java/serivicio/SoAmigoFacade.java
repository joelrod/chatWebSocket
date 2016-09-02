/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serivicio;

import entities.SoAmigo;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ihsa
 */
@javax.ejb.Stateless
public class SoAmigoFacade extends AbstractFacade<SoAmigo> implements SoAmigoFacadeLocal {
    @PersistenceContext(unitName = "socialPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SoAmigoFacade() {
        super(SoAmigo.class);
    }
    
}
