/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serivicio;

import entities.SoTipoUsuario;
import java.util.List;

/**
 *
 * @author ihsa
 */
@javax.ejb.Local
public interface SoTipoUsuarioFacadeLocal {

    void create(SoTipoUsuario soTipoUsuario);

    void edit(SoTipoUsuario soTipoUsuario);

    void remove(SoTipoUsuario soTipoUsuario);

    SoTipoUsuario find(Object id);

    List<SoTipoUsuario> findAll();

    List<SoTipoUsuario> findRange(int[] range);

    int count();
    
}
