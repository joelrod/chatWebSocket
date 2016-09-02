/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serivicio;

import entities.SiUsuario;
import java.util.List;

/**
 *
 * @author ihsa
 */
@javax.ejb.Local
public interface SiUsuarioFacadeLocal {

    void create(SiUsuario siUsuario);

    void edit(SiUsuario siUsuario);

    void remove(SiUsuario siUsuario);

    SiUsuario find(Object id);

    List<SiUsuario> findAll();

    List<SiUsuario> findRange(int[] range);

    int count();
    
}
