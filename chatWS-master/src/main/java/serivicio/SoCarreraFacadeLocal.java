/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serivicio;

import entities.SoCarrera;
import java.util.List;

/**
 *
 * @author ihsa
 */
@javax.ejb.Local
public interface SoCarreraFacadeLocal {

    void create(SoCarrera soCarrera);

    void edit(SoCarrera soCarrera);

    void remove(SoCarrera soCarrera);

    SoCarrera find(Object id);

    List<SoCarrera> findAll();

    List<SoCarrera> findRange(int[] range);

    int count();
    
}
