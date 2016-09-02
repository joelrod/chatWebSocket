/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serivicio;

import entities.SoAmigo;
import java.util.List;

/**
 *
 * @author ihsa
 */
@javax.ejb.Local
public interface SoAmigoFacadeLocal {

    void create(SoAmigo soAmigo);

    void edit(SoAmigo soAmigo);

    void remove(SoAmigo soAmigo);

    SoAmigo find(Object id);

    List<SoAmigo> findAll();

    List<SoAmigo> findRange(int[] range);

    int count();
    
}
